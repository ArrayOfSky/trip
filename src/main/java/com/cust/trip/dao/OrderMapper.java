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

}
