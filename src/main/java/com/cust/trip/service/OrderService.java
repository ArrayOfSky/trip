package com.cust.trip.service;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.User;
import com.github.pagehelper.PageInfo;

import java.sql.Timestamp;

/**
 * @author gyx
 * 2022/9/8
 */
public interface OrderService {

    /**
     * 取得所有的订单分页
     *
     * @param pageNum  num
     * @param pageSize size
     * @return orders
     */
    PageInfo<Order> getAllOrdersForPage(int pageNum, int pageSize);

    /**
     * 查询用户订单
     *
     * @param pageNum  num
     * @param pageSize size
     * @param userId   用户id
     * @return orders
     */
    PageInfo<Order> getOrdersByUserId(int pageNum, int pageSize, int userId);

    /**
     * 筛选不同状态订单
     *
     * @param pageNum           num
     * @param pageSize          size
     * @param statusKind        状态类型
     * @param statusDescription 状态描述
     * @return orders
     */
    PageInfo<Order> getOrdersByStatus(int pageNum, int pageSize, String statusKind, String statusDescription);

    /**
     * 筛选产品订单
     *
     * @param pageNum     num
     * @param pageSize    size
     * @param productName 产品名称
     * @return orders
     */
    PageInfo<Order> getOrdersByProductName(int pageNum, int pageSize, String productName);

    /**
     * 筛选时间段订单
     *
     * @param time1    先
     * @param time2    后
     * @param pageNum  num
     * @param pageSize size
     * @return orders
     */
    PageInfo<Order> getOrdersBtDates(Timestamp time1, Timestamp time2, int pageNum, int pageSize);

}
