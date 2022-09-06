package com.cust.trip.dao;

import com.cust.trip.bean.Order;
import org.apache.ibatis.annotations.Mapper;

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
     * 依据商品id获取订单
     * @param productId 商品id
     * @return 订单列表
     */
    List<Order> getOrderByproductId(int productId);


    /**
     * 依据用户id获取订单
     * @param userId 用户id
     * @return 订单列表
     */
    List<Order> getOrderByUserId(int userId);

    /**
     * 依据状态获取订单
     * @param status 订单状态
     * @return 订单列表
     */
    List<Order> getOrderByStatus(int status);

    /**
     * 依据日期获取订单
     * @param createTime 订单生成日期
     * @return 订单列表
     */
    List<Order> getOrderByDate(Timestamp createTime);

    /**
     * 获取时间段内订单
     * @param createTimePre 时间（先）
     * @param createTimePo  时间（后）
     * @return 订单列表
     */
    List<Order> getOrdersBtDates(Timestamp createTimePre,Timestamp createTimePo);

    /**
     * 获取指定折扣区间内的订单
     * @param lowDiscount 最低折扣
     * @param highDiscount 最高折扣
     * @return 订单列表
     */
    List<Order> getOrderBtDisCounts(double lowDiscount,double highDiscount);
}
