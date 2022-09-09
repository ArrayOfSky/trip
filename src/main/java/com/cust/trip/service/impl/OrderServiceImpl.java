package com.cust.trip.service.impl;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.User;
import com.cust.trip.dao.OrderMapper;
import com.cust.trip.dao.UserMapper;
import com.cust.trip.service.OrderService;
import com.cust.trip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gyx
 * 2022/9/8
 */
@Service
@Transactional(rollbackFor = Exception.class,timeout = 3)
public class OrderServiceImpl  {
    private OrderMapper orderMapper;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


}
