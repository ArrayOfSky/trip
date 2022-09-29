package com.cust.trip.service;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.Product;
import com.cust.trip.bean.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author gyx
 * 2022/9/8
 */
public interface UserService {
    /**
     * 获取所有的用户并分页
     *
     * @param pageNum  页数
     * @param pageSize 页尺寸
     * @return pageInfo
     */
    PageInfo<User> getAllUsers(int pageNum, int pageSize);

    /**
     * 获取特定手机号的用户
     *
     * @param userPhoneNumber -
     * @param pageNum-
     * @param pageSize-
     * @return -
     */
    PageInfo<User> getUserByPhoneNumber(String userPhoneNumber, int pageNum, int pageSize);

    /**
     * 获取特定手机号的用户
     *
     * @param userPhoneNumber -
     * @return -
     */
    List<User> getUserByPhoneNumber(String userPhoneNumber);


    /**
     * 通过用户名获取用户对象
     *
     * @param name 用户名
     * @return 用户对象列表（用户名可能重复）
     */
    List<User> getUserByName(String name);

    /**
     * 通过用户名获取用户对象并分页
     *
     * @param name      用户名
     * @param pageNum -
     * @param pageSize-
     * @return -
     */
    PageInfo<User> getUserByName(String name, int pageNum, int pageSize);

    /**
     * 用户注册
     *
     * @param user -
     */
    void register(User user);

    /**
     * 生成订单
     * @param user 用户
     * @param product 产品
     * @return Order
     */
    Order order(User user, Product product);
    //    boolean login(User user);
//
//    boolean logout(User user);
//
//
//    int recharge(User user, Double recharge);
//
//    int consumption(User user, Double consumption);
//
//    int deConsumption(User user, Double deConsumption);
//
//    boolean useBalance(User user, Double useBalance);
//

//
//    int updatePhoneNumber(User user, String newPhoneNumber);


}
