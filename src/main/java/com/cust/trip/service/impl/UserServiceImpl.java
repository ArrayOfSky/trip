package com.cust.trip.service.impl;

import com.cust.trip.bean.User;
import com.cust.trip.dao.UserMapper;
import com.cust.trip.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gyx
 * 2022/9/8
 */
@Service
@Transactional(rollbackFor = Exception.class,timeout = 3)
public class UserServiceImpl implements UserService{
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private UserMapper userMapper;

    @Override
    public PageInfo<User> getAllUsers(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.selectAllUsers();
        return new PageInfo<>(users);
    }


    @Override
    public int recharge(User user, Double recharge) {
        return userMapper.rechargeBalance(user.getId(),recharge);
    }

    @Override
    public int consumption(User user, Double consumption) {
       return userMapper.consumption(user.getId(),consumption);
    }

    @Override
    public int deConsumption(User user, Double deConsumption) {
        return userMapper.deConsumption(user.getId(),deConsumption);
    }

    @Override
    public boolean useBalance(User user, Double useBalance) {
        return false;
    }
}
