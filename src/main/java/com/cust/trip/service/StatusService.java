package com.cust.trip.service;

import com.cust.trip.bean.Status;
import com.github.pagehelper.PageInfo;

/**
 * @author GYF
 * @Data 2022.9.11
 */
public interface StatusService {

    PageInfo<Status> selectAllStatus(int pageNum,int pageSize);

    Status selectStatusByDescription(String statusDescription);

    int insertStatus(Status status);

    int deleteStatus();




}
