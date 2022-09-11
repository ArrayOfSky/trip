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
     * @param status 状态
     * @return orders
     */
    List<Order> getOrdersByStatus(int status);

    /**
     * 依据用户id查询订单
     * @param userId 用户id
     * @return orders
     */
    List<Order> getOrdersByUserId(int userId);

    /**
     * 依据产品id查询订单
     * @param productId 产品订单
     * @return orders
     */
    List<Order> getOrdersByProductId(int productId);


    /**
     * 筛选时间段订单
     * @param createTimePre 时间1
     * @param createTimePo 时间2
     * @return orders
     */
    List<Order> getOrdersBtDates(Timestamp createTimePre,Timestamp createTimePo);

}
