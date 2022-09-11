package com.cust.trip.controller;

import com.cust.trip.bean.Order;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gyx
 * 2022/9/11
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/{pageNum}/{pageSize}")
    public ReturnData getAllOrders(@PathVariable("pageNum") int pageNum
            , @PathVariable("pageSize") int pageSize){
        PageInfo<Order> pageInfo = orderService.getAllOrdersForPage(pageNum, pageSize);
        return null;
    }
}
