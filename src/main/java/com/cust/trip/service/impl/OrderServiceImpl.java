package com.cust.trip.service.impl;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.Product;
import com.cust.trip.bean.Status;
import com.cust.trip.bean.User;
import com.cust.trip.dao.OrderMapper;
import com.cust.trip.dao.ProductMapper;
import com.cust.trip.dao.StatusMapper;
import com.cust.trip.dao.UserMapper;
import com.cust.trip.service.OrderService;
import com.cust.trip.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author gyx
 * 2022/9/8
 */
@Service
@Transactional(rollbackFor = Exception.class, timeout = 3)
public class OrderServiceImpl implements OrderService {

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
    public PageInfo<Order> getAllOrdersForPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //获取所有的订单
        List<Order> orders = orderMapper.getAllOrders();
        return new PageInfo<>(orders);
    }

    @Override
    public PageInfo<Order> getOrdersByProductName(int pageNum, int pageSize, String productName) {
        PageHelper.startPage(pageNum, pageSize);
        //查找对应的商品，并得到商品id
        int productId=0;
        for (Product product : productMapper.selectAllProduct()) {
            if(product.getProductName().equals(productName)){
                productId=product.getProductId();
            }
        }
        List<Order> orders = orderMapper.getOrdersByProductId(productId);
        return new PageInfo<>(orders);
    }

    @Override
    public PageInfo<Order> getOrdersByUser(int pageNum, int pageSize, User user) {
        int userId = user.getUserId();
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.getOrdersByUserId(userId);
        return new PageInfo<>(orders);

    }

    @Override
    public PageInfo<Order> getOrdersByStatus(int pageNum, int pageSize, String statusKind,String statusDescription){
        int statusId=-1;
        //找出所有的status进行匹配，并找出对应的id
        for (Status selectAllStatus : statusMapper.selectAllStatus()) {
            if(selectAllStatus.getStatusKind().equals(statusKind)&&selectAllStatus.getStatusDescription().equals(statusDescription)){
                statusId=selectAllStatus.getStatusId();
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.getOrdersByStatus(statusId);
        return new PageInfo<>(orders);
    }

    @Override
    public int saveOrder(Order order) {
        //直接新增用户
        return orderMapper.saveOrder(order);
    }

    @Override
    public PageInfo<Order> getOrdersBtDates(Timestamp time1, Timestamp time2, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderMapper.getOrdersBtDates(time1, time2);
        return new PageInfo<>(orders);
    }
}
