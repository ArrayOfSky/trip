package com.cust.trip.service.impl;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.Product;
import com.cust.trip.bean.User;
import com.cust.trip.dao.UserMapper;
import com.cust.trip.exceptionhandle.exception.user.UserExistedException;
import com.cust.trip.exceptionhandle.exception.user.UserNotFoundException;
import com.cust.trip.service.OrderService;
import com.cust.trip.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Cacheable(key = "'selectAllUsers'+#pageNum+#pageSize")
    public PageInfo<User> getAllUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAllUsers();
        return new PageInfo<>(users);
    }


    @Override
    public Order order(User user, Product product) {
        Order order = new Order();
        order.setOrderUserName(user.getUserName());
        order.setOrderProductName(product.getProductName());
        return order;
    }

    @Override
    public PageInfo<User> getUserByName(String name, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        //获取数据
        List<User> users = userMapper.selectUsersByName(name);
        //判断是否为空
        if(users==null||users.size()==0){
            throw new UserNotFoundException();
        }
        return new PageInfo<>(users);
    }

    @Override
    @Cacheable(key = "'getUserByName'+#name")
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
    @Cacheable(key = "'getUserByPhoneNumber'+#userPhoneNumber+#pageNum+#pageSize")
    public PageInfo<User> getUserByPhoneNumber(String userPhoneNumber,int pageNum,int pageSize) {
        //获取数据
        PageHelper.startPage(pageNum,pageSize);
        List<User> user = userMapper.selectUserByPhoneNumber(userPhoneNumber);
        return  new PageInfo<>(user);
    }

    @Override
    @Cacheable(key = "'getUserByPhoneNumber'+#userPhoneNumber")
    public List<User> getUserByPhoneNumber(String userPhoneNumber) {
        return userMapper.selectUserByPhoneNumber(userPhoneNumber);
    }

    @Override
    @CacheEvict(cacheNames = "user",allEntries = true)
    public void register(User user) {
        //排查是否已经注册过了
        if(userMapper.getUserById(user.getUserId())!=null){
            throw new UserExistedException();
        }
        userMapper.insertUser(user);
    }
}
