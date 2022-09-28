package com.cust.trip.service.impl;

import com.cust.trip.bean.Kind;
import com.cust.trip.dao.KindMapper;
import com.cust.trip.exceptionhandle.exception.kind.KindAlreadyExistsException;
import com.cust.trip.exceptionhandle.exception.kind.KindNotFoundException;
import com.cust.trip.service.KindService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Service
@Transactional(rollbackFor=Exception.class)
@Slf4j
@CacheConfig(cacheNames = "kind")
public class KindServiceImpl implements KindService {

    @Autowired
    KindMapper kindMapper;

    @Override
    @CacheEvict(cacheNames = "kind",allEntries = true)
    public void addKind(Kind kind) {
        //获取所有kind
        ArrayList<Kind> array = (ArrayList<Kind>) kindMapper.selectAll();
        //查询是否重复
        for(Kind a : array){
            if(a.getKindName().equals(kind.getKindName())){
                throw new KindAlreadyExistsException();
            }
        }
        //添加
        kindMapper.insertKind(kind);
    }

    @Override
    @CacheEvict(cacheNames = "kind",allEntries = true)
    public void deleteKind(String kindName) {
        ArrayList<Kind> array = (ArrayList<Kind>) kindMapper.selectAll();
        for(Kind a : array){
            if(a.getKindName().equals(kindName)){
                kindMapper.deleteKind(kindName);
            }
        }
        throw new KindNotFoundException();
    }

    @Override
    @Cacheable(key="'selectAllKind' +#pageNum+  #pageSize")
    public PageInfo<Kind> selectAllKind(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Kind> array = kindMapper.selectAll();
       return new PageInfo<>(array);

    }

    @Override
    @Cacheable(key="'selectKindByName' + #kindName")
    public Kind selectKindByName(String kindName) {
        //获取所有
        ArrayList<Kind> array = (ArrayList<Kind>) kindMapper.selectAll();
        //循环查询
        for(Kind a : array){
            if(a.getKindName().equals(kindName)){
                return a;
            }
        }
        throw new KindNotFoundException();
    }

    @CacheEvict(cacheNames = "kind",allEntries = true)
    @Override
    public void updateKind(String kindName1, String kindName2) {
        //获取所有
        ArrayList<Kind> array = (ArrayList<Kind>) kindMapper.selectAll();
        //循环查询
        for (Kind a: array){
            if(a.getKindName().equals(kindName1)){
                //因为后续是通过id来定位kind，我可以直接更改name
                a.setKindName(kindName2);
                kindMapper.updateKind(a);
            }
        }
        throw new KindNotFoundException();
    }

}
