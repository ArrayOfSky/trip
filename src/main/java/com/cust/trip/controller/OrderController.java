package com.cust.trip.controller;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.Product;
import com.cust.trip.bean.User;
import com.cust.trip.commom.CodeEnum;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

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

    /**
     * 显示全部订单
     * @param pageNum 页数
     * @param pageSize 总页数
     * @return data
     */
    @GetMapping("/{pageNum}/{pageSize}")
    public ReturnData getAllOrders(@PathVariable("pageNum") int pageNum
            , @PathVariable("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getAllOrdersForPage(pageNum, pageSize);

        //封装对象
        returnData.setData(pageInfo.getList());
        //返回
        return returnData;
    }

    /**
     * 筛选某一用户订单
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/{user}/{pageNum}/{pageSize}")
    public ReturnData getOrdersByUser(@PathVariable("user") User user
            , @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getOrdersByUser(pageNum, pageSize, user);
        //封装对象
        returnData.setData(pageInfo.getList());
        //返回
        return returnData;
    }

    /**
     * 筛选某一状态订单
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/{status}/{pageNum}/{pageSize}")
    public ReturnData getOrdersByStatus(@PathVariable("status") int status
            , @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getOrdersByStatus(pageNum,pageSize,status);
        //封装对象
        returnData.setData(pageInfo.getList());
        //返回
        return returnData;
    }

    @GetMapping("/{product}/{pageNum}/{pageSize}")
    public ReturnData getOrdersByProduct(@PathVariable("product") Product product
            , @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getOrdersByProductId(pageNum,pageSize,product.getId());
        //封装对象
        returnData.setData(pageInfo.getList());
        //返回
        return returnData;
    }

    @GetMapping("/{time1}/{time2}/{pageNum}/{pageSize}")
    public ReturnData getOrdersBtDates(@PathVariable("time1")Date time1,@PathVariable("time2")Date time2
            , @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getOrdersBtDates(new Timestamp(time1.getTime()),new Timestamp(time2.getTime()),pageNum,pageSize);
        //封装对象
        returnData.setData(pageInfo.getList());
        //返回
        return returnData;
    }



}
