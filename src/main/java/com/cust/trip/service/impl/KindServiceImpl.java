package com.cust.trip.service.impl;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.User;
import com.cust.trip.dao.KindMapper;
import com.cust.trip.service.KindService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Service
public class KindServiceImpl implements KindService {

    @Autowired
    KindMapper kindMapper;

    @Override
    public int addKind(Kind kind) {
        //获取所有kind
        ArrayList<Kind> array = (ArrayList<Kind>) kindMapper.selectAll();
        //查询是否重复
        for(Kind a : array){
            if(a.getKindName().equals(kind.getKindName())){
                return 0;
            }
        }
        //添加
        kindMapper.insertKind(kind);
        return 1;
    }

    @Override
    public int deleteKind(String kindName) {
        kindMapper.deleteKind(kindName);
        return 1;
    }

    @Override
    public PageInfo<Kind> selectAllKind(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Kind> array = kindMapper.selectAll();
       return new PageInfo<>(array);
    }

    @Override
    public Kind selectKindByName(String kindName) {
        //获取所有
        ArrayList<Kind> array = (ArrayList<Kind>) kindMapper.selectAll();
        //循环查询
        for(Kind a : array){
            if(a.getKindName().equals(kindName)){
                return a;
            }
        }
        return null;
    }

    @Override
    public int updateKind(String kindName1, String kindName2) {
        //获取所有
        ArrayList<Kind> array = (ArrayList<Kind>) kindMapper.selectAll();
        //循环查询
        for (Kind a: array){
            if(a.getKindName().equals(kindName1)){
                a.setKindName(kindName2);//因为后续是通过id来定位kind，我可以直接更改name
                kindMapper.updateKind(a);
                return 1;
            }
        }
        return 0;
    }

}
