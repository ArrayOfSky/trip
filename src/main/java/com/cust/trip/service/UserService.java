package com.cust.trip.service;

import com.cust.trip.bean.User;

import java.util.List;

/**
 * @author gyx
 * 2022/9/8
 */
public interface UserService {
    /**
     * 获得所有的用户列表
     * @return 用户列表
     */
    List<User> getAllUsers();

    List<User> getUsersForPage(int pageNum);

    boolean login(User user);

    boolean logout(User user);

    boolean register(User user);

    boolean updateUser(User user);

    boolean recharge(Double recharge);

    boolean consumption(Double consumption);

    boolean deConsumption(Double deConsumption);

    boolean useBalance(Double useBalance);




}
