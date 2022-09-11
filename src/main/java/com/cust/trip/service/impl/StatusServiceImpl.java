package com.cust.trip.service.impl;

import com.cust.trip.bean.Status;
import com.cust.trip.dao.StatusMapper;
import com.cust.trip.service.StatusService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.11
 */
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
    public Status selectStatusByDescription(String statusDescription) {
        return statusMapper.selectStatusByDescription(statusDescription);
    }

    @Override
    public int insertStatus(Status status) {
        List<Status> array = statusMapper.selectAllStatus();
        for(Status a : array){
            if(a.getStatusDescription().equals(status.getStatusDescription())){
                return 0;
            }
        }
        statusMapper.insertStatus(status);
        return 1;
    }

    @Override
    public int deleteStatusByDescription(String statusDescription) {
        List<Status> array = statusMapper.selectAllStatus();
        for(Status a : array){
            if(a.getStatusDescription().equals(statusDescription)){
                return 0;
            }
        }
        statusMapper.deleteStatus(statusDescription);
        return 1;
    }


}
