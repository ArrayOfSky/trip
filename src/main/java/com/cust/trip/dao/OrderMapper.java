package com.cust.trip.dao;

import com.cust.trip.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author guoyixing
 * 2022/9/6
 */
@Mapper
public interface OrderMapper {

    /**
     * 获取所有订单信息
     * @return 订单列表
     */
    List<Order> getAllOrders();

    /**
     * 新增订单
     * @param order 新增的订单
     * @return row
     */
    int saveOrder(Order order);

    /**
     * 依据状态查询订单数据
     * @param orderStatusKind 类型
     * @param  orderStatusDescription 描述
     * @return orders
     */
    List<Order> getOrdersByStatus(String orderStatusKind,String orderStatusDescription);

    /**
     * 依据用户id查询订单
     * @param orderUserId 用户id
     * @return orders
     */
    List<Order> getOrdersByUserId(int orderUserId);

    /**
     * 依据产品id查询订单
     * @param orderProductId 产品订单
     * @return orders
     */
    List<Order> getOrdersByProductId(int orderProductId);


    /**
     * 筛选时间段订单
     * @param orderCreateTimePre 时间1
     * @param orderCreateTimePo 时间2
     * @return orders
     */
    List<Order> getOrdersBtDates(Timestamp orderCreateTimePre,Timestamp orderCreateTimePo);

}
