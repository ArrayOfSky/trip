package com.cust.trip.service;

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
     * @param pageNum 页数
     * @param pageSize 页尺寸
     * @return pageInfo
     */
    PageInfo<User> getAllUsers(int pageNum, int pageSize);

   /* boolean login(User user);

    boolean logout(User user);

    boolean register(User user);

    int recharge(User user, Double recharge);

    int consumption(User user, Double consumption);

    int deConsumption(User user, Double deConsumption);

    boolean useBalance(User user, Double useBalance);

    boolean order(User user, Product product);

    int updatePhoneNumber(User user, String newPhoneNumber);

    */

    User getUserByPhoneNumber(String phoneNumber);

    /**
     * 通过用户名获取用户对象
     * @param name 用户名
     * @return 用户对象列表（用户名可能重复）
     */
    List<User> getUserByName(String name);


}
