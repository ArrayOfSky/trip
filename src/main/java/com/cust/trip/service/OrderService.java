package com.cust.trip.service;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author gyx
 * 2022/9/8
 */
public interface OrderService {

    /**
     * 取得所有的订单分页
     * @param pageNum num
     * @param pageSize size
     * @return orders
     */
    PageInfo<Order> getAllOrdersForPage(int pageNum, int pageSize);

    /**
     * 新增订单
     * @param order new order
     * @return row
     */
    int saveOrder(Order order);

    /**
     * 查询用户订单
     * @param pageNum num
     * @param pageSize size
     * @param user user
     * @return orders
     */
    PageInfo<Order> getOrdersByUser(int pageNum, int pageSize, User user);

    /**
     * 查询不同状态订单
     * @param pageNum num
     * @param pageSize size
     * @param status 状态
     * @return orders
     */
    PageInfo<Order> getOrdersByStatus(int pageNum, int pageSize, int status);

    /**
     * 查询产品订单
     * @param pageNum num
     * @param pageSize size
     * @param productId 产品id
     * @return orders
     */
    PageInfo<Order> getOrdersByProductId(int pageNum, int pageSize, int productId);


}
