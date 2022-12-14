package com.cust.trip.service.impl;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.Product;
import com.cust.trip.bean.Status;
import com.cust.trip.bean.User;
import com.cust.trip.commom.Code;
import com.cust.trip.dao.OrderMapper;
import com.cust.trip.dao.ProductMapper;
import com.cust.trip.dao.StatusMapper;
import com.cust.trip.dao.UserMapper;
import com.cust.trip.exceptionhandle.exception.product.ProductNotFoundException;
import com.cust.trip.exceptionhandle.exception.status.StatusNotFoundException;
import com.cust.trip.exceptionhandle.exception.user.UserNotFoundException;
import com.cust.trip.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author gyx
 * 2022/9/8
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
@CacheConfig(cacheNames = "order")
public class OrderServiceImpl implements OrderService {


    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private StatusMapper statusMapper;

    @Autowired
    public void setStatusMapper(StatusMapper statusMapper) {
        this.statusMapper = statusMapper;
    }

    private OrderMapper orderMapper;

    private ProductMapper productMapper;

    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    @Cacheable(key = "'getAllOrdersForPage'+#pageNum+#pageSize")
    public PageInfo<Order> getAllOrdersForPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //?????????????????????
        List<Order> orders = orderMapper.getAllOrders();
        return new PageInfo<>(orders);
    }

    @Override
    @Cacheable(key = "'getOrdersByProductName'+#pageNum+#pageSize+#productName")
    public PageInfo<Order> getOrdersByProductName(int pageNum, int pageSize, String productName) {
        //???????????????????????????????????????id
        int productId = 0;
        for (Product product : productMapper.selectAllProduct()) {
            if (product.getProductName().equals(productName)) {
                productId = product.getProductId();
            }
        }
        if (productId == 0) {
            //????????????????????????????????????
            throw new ProductNotFoundException("???????????????????????????", Code.INVALID_REQUEST);
        }
        //?????????????????????????????????
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.getOrdersByProductId(productId);
        return new PageInfo<>(orders);
    }

    @Override
    public void saveOrder(Order order) {
        List<Product> products = productMapper.selectAllProduct();
        int productId=-1,userId=-1,statusId=-1;
        //????????????
        for (Product product : products) {
            if(product.getProductName().equals(order.getOrderProductName())){
                productId=product.getProductId();
            }
        }
        if(productId==-1){
            throw new ProductNotFoundException();
        }
        //????????????
        List<User> users = userMapper.selectUsersByName(order.getOrderUserName());
        if(users.size()!=0&&users.get(0)!=null){
            userId=users.get(0).getUserId();
        }else{
            throw new UserNotFoundException();
        }
        //????????????
        Status status = statusMapper.selectStatusByName(order.getOrderStatusName());
        if(status==null){
            throw new StatusNotFoundException("??????????????????",Code.INVALID_REQUEST);
        }
        statusId=status.getStatusId();
        //????????????
        orderMapper.saveOrder(order,statusId,productId,userId);
    }

    @Override
    @Cacheable(key = "'getOrdersByUserPhoneNumber'+#userPhoneNumber+#pageNum+#pageSize")
    public PageInfo<Order> getOrdersByUserPhoneNumber(String userPhoneNumber, int pageNum, int pageSize) {
        List<User> users = userMapper.selectUserByPhoneNumber(userPhoneNumber);
        if (users.size() == 0) {
            throw new UserNotFoundException();
        }
        return this.getOrdersByUserId(pageNum, pageSize, users.get(0).getUserId());
    }

    @Override
    @Cacheable(key = "'getOrdersByUserId'+#pageNum+#pageSize+#userId")
    public PageInfo<Order> getOrdersByUserId(int pageNum, int pageSize, int userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.getOrdersByUserId(userId);
        return new PageInfo<>(orders);
    }

    @Override
    @Cacheable(key = "'getOrdersByStatus'+#pageNum+#pageSize+#statusKind+#statusDescription")
    public PageInfo<Order> getOrdersByStatus(int pageNum, int pageSize, String statusKind, String statusDescription) {
        int statusId = 0;
        //???????????????status?????????????????????????????????id
        for (Status selectAllStatus : statusMapper.selectAllStatus()) {
            if (selectAllStatus.getStatusCategory().equals(statusKind) && selectAllStatus.getStatusName().equals(statusDescription)) {
                statusId = selectAllStatus.getStatusId();
            }
        }
        if (statusId == 0) {
            throw new StatusNotFoundException();
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.getOrdersByStatus(statusId);
        return new PageInfo<>(orders);
    }


    @Override
    @Cacheable(key = "'getOrdersByDates'+#time1+#time2+#pageNum+#pageSize")
    public PageInfo<Order> getOrdersByDates(Timestamp time1, Timestamp time2, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.getOrdersBtDates(time1, time2);
        return new PageInfo<>(orders);
    }
}
