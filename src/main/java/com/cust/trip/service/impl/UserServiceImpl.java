package com.cust.trip.service.impl;

import com.cust.trip.bean.Product;
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
    public boolean login(User user) {
        return false;
    }

    @Override
    public boolean logout(User user) {
        return false;
    }

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public boolean order(User user, Product product) {
        //生成订单，扣款
        return true;
    }

    @Override
    public boolean useBalance(User user, Double useBalance) {
        if(user.getBalance()<useBalance){
            return false;
        }
        else{
            //扣除余额
            userMapper.useBalance(user.getId(),useBalance);
            //统计消费
            userMapper.consumption(user.getId(),useBalance);
            return true;
        }
    }
}
