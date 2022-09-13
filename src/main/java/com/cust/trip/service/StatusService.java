package com.cust.trip.service;

import com.cust.trip.bean.Status;
import com.github.pagehelper.PageInfo;

/**
 * @author GYF
 * @Data 2022.9.11
 */
public interface StatusService {

    /**
     * 分页查找所有状态
     * @param pageNum 第几页
     * @param pageSize 一页多少
     * @return 分页状态
     */
    PageInfo<Status> selectAllStatus(int pageNum,int pageSize);

    /**
     * 根据状态名查找状态
     * @param statusName 状态名
     * @return 状态
     */
    Status selectStatusByName(String statusName);

    /**
     * 增加状态
     * @param status 状态
     * @return 0 失败 1 成功
     */
    int insertStatus(Status status);

    /**
     * 根据姓名删除
     * @param statusName 状态名
     * @return 0失败 1成功
     */
    int deleteStatusByName(String statusName);




}
