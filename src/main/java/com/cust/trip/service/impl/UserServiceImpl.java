package com.cust.trip.service.impl;

import com.cust.trip.bean.User;
import com.cust.trip.dao.UserMapper;
import com.cust.trip.exceptionhandle.exception.user.UserNotFoundException;
import com.cust.trip.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author gyx
 * 2022/9/8
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public PageInfo<User> getAllUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAllUsers();
        return new PageInfo<>(users);
    }


    @Override
    public List<User> getUserByName(String name) {
        //获取数据
        List<User> users = userMapper.selectUsersByName(name);
        //判断是否为空
        if(users==null||users.size()==0){
            throw new UserNotFoundException();
        }
        return users;
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        //获取数据
        User user = userMapper.selectUserByPhoneNumber(phoneNumber);
        //判断是否为空
        if(user==null){
            throw new UserNotFoundException();
        }
        return user;
    }
}
