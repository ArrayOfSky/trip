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
     * 获得所有的用户列表
     *
     * @return 用户列表
     */
    PageInfo<User> getAllUsers(int pageNum, int pageSize);

    boolean login(User user);

    boolean logout(User user);

    boolean register(User user);

    int recharge(User user, Double recharge);

    int consumption(User user, Double consumption);

    int deConsumption(User user, Double deConsumption);

    boolean useBalance(User user, Double useBalance);

    boolean order(User user, Product product);

    int updatePhoneNumber(User user, String newPhoneNumber);

    User getUserByPhoneNumber(String phoneNumber);

    List<User> getUserByName(String name);


}
