package com.cust.trip.service.impl;

import com.cust.trip.bean.Status;
import com.cust.trip.dao.StatusMapper;
import com.cust.trip.exceptionhandle.exception.status.StatusAlreadyExistsException;
import com.cust.trip.exceptionhandle.exception.status.StatusNotFoundException;
import com.cust.trip.service.StatusService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "status")
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusMapper statusMapper;

    @Override
    @Cacheable(key = "'selectAllStatus'+#pageNum+#pageSize")
    public PageInfo<Status> selectAllStatus(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Status> array = statusMapper.selectAllStatus();
        return new PageInfo<>(array);
    }

    @Override
    @Cacheable(key = "'selectStatusByName'+#statusName")
    public Status selectStatusByName(String statusName) {
        return statusMapper.selectStatusByName(statusName);
    }

    @Override
    @CacheEvict(cacheNames = "status",allEntries = true)
    public void insertStatus(Status status) {
        List<Status> array = statusMapper.selectAllStatus();
        for(Status a : array){
            if(a.getStatusName().equals(status.getStatusName())){
               throw new StatusAlreadyExistsException();
            }
        }
        statusMapper.insertStatus(status);
    }

    @Override
    @CacheEvict(cacheNames = "status",allEntries = true)
    public void deleteStatusByName(String statusName) {
        List<Status> array = statusMapper.selectAllStatus();
        for(Status a : array){
            if(a.getStatusName().equals(statusName)){
                statusMapper.deleteStatus(statusName);
                return;
            }
        }
        throw new StatusNotFoundException();
    }


}
