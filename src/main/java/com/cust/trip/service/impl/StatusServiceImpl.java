package com.cust.trip.service.impl;

import com.cust.trip.bean.Status;
import com.cust.trip.dao.StatusMapper;
import com.cust.trip.service.StatusService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.11
 */
@Service
@Transactional(rollbackFor=Exception.class)
@Slf4j
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusMapper statusMapper;

    @Override
    public PageInfo<Status> selectAllStatus(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Status> array = statusMapper.selectAllStatus();
        return new PageInfo<>(array);
    }

    @Override
    public Status selectStatusByName(String statusName) {
        return statusMapper.selectStatusByName(statusName);
    }

    @Override
    public int insertStatus(Status status) {
        List<Status> array = statusMapper.selectAllStatus();
        for(Status a : array){
            if(a.getStatusName().equals(status.getStatusName())){
                return 0;
            }
        }
        statusMapper.insertStatus(status);
        return 1;
    }

    @Override
    public int deleteStatusByName(String statusName) {
        List<Status> array = statusMapper.selectAllStatus();
        for(Status a : array){
            if(a.getStatusName().equals(statusName)){
                return 0;
            }
        }
        statusMapper.deleteStatus(statusName);
        return 1;
    }


}
