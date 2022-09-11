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
        ArrayList<Kind> array = (ArrayList<Kind>) kindMapper.selectAll();
        for(Kind a : array){
            if(a.getName().equals(kind.getName())){
                return 0;
            }
        }
        kindMapper.insertKind(kind);
        return 1;
    }

    @Override
    public int deleteKind(String name) {
        kindMapper.deleteKind(name);
        return 1;
    }

    @Override
    public PageInfo<Kind> selectAllKind(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Kind> array = kindMapper.selectAll();
       return new PageInfo<>(array);
    }

    @Override
    public Kind selectKindByName(String name) {
        ArrayList<Kind> array = (ArrayList<Kind>) kindMapper.selectAll();
        for(Kind a : array){
            if(a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

    @Override
    public int updateKind(String name1, String name2) {
        ArrayList<Kind> array = (ArrayList<Kind>) kindMapper.selectAll();
        for (Kind a: array){
            if(a.getName().equals(name1)){
                a.setName(name2);//因为后续是通过id来定位kind，我可以直接更改name
                kindMapper.updateKind(a);
                return 1;
            }
        }
        return 0;
    }

}
