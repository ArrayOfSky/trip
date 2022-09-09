package com.cust.trip.service.impl;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.User;
import com.cust.trip.dao.OrderMapper;
import com.cust.trip.dao.UserMapper;
import com.cust.trip.service.OrderService;
import com.cust.trip.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author gyx
 * 2022/9/8
 */
@Service
@Transactional(rollbackFor = Exception.class, timeout = 3)
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public PageInfo<Order> getAllOrdersForPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //获取所有的订单
        List<Order> orders = orderMapper.getAllOrders();
        return new PageInfo<>(orders);
    }

    @Override
    public PageInfo<Order> getOrdersByProductId(int pageNum, int pageSize, int productId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.getOrdersByProductId(productId);
        return new PageInfo<>(orders);
    }

    @Override
    public PageInfo<Order> getOrdersByUser(int pageNum, int pageSize, User user) {
        int userId = user.getId();
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.getOrdersByUserId(userId);
        return new PageInfo<>(orders);

    }

    @Override
    public PageInfo<Order> getOrdersByStatus(int pageNum, int pageSize, int status) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.getOrdersByStatus(status);
        return new PageInfo<>(orders);
    }

    @Override
    public int saveOrder(Order order) {
        //直接新增用户
        return orderMapper.saveOrder(order);
    }

    @Override
    public PageInfo<Order> getOrdersBtDates(Timestamp time1, Timestamp time2,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Order> orders=orderMapper.getOrdersBtDates(time1,time2);
        return new PageInfo<>(orders);
    }
}
