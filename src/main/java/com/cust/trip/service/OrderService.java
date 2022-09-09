package com.cust.trip.service;

import com.cust.trip.bean.Order;

import java.util.List;

/**
 * @author gyx
 * 2022/9/8
 */
public interface OrderService {
    /**
     * 获取所有订单
     * @return 所有订单
     */
    List<Order> getAllOrders();

    List<Order> getAllOrdersForPage(int pageNum);
}
