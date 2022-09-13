package com.cust.trip.controller;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.User;
import com.cust.trip.commom.Code;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.OrderService;
import com.cust.trip.service.UserService;
import com.cust.trip.utils.DateUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author gyx
 * 2022/9/11
 */
@RestController
@RequestMapping("/order")
@Api(value = "Order", tags = "订单模块")
@Slf4j
public class OrderController {

    private OrderService orderService;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query", required = true)
    })
    @ApiOperation(value = "分页查询所有订单", notes = "分页查询所有订单")
    @PostMapping("/getAllOrders")
    public ReturnData getAllOrders(@RequestParam("pageNum") int pageNum
            , @RequestParam("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getAllOrdersForPage(pageNum, pageSize);
        //封装对象
        returnData.setData(pageInfo);
        returnData.setCode(Code.OK);
        returnData.setMsg("获取成功");
        //返回
        return returnData;
    }


    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer", paramType = "query", required = true),
                    @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query", required = true),
                    @ApiImplicitParam(name = "statusKind", value = "订单状态类型", dataType = "String", paramType = "query", required = true),
                    @ApiImplicitParam(name = "statusDescription", value = "订单状态描述", dataType = "String", paramType = "query", required = true)
            }
    )
    @ApiOperation(value = "获取特定状态的订单", notes = "获取特定状态的订单")
    @PostMapping("/getOrdersByStatus")
    public ReturnData getOrdersByStatus(@RequestParam("statusKind") String statusKind, @RequestParam("statusDescription") String statusDescription
            , @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getOrdersByStatus(pageNum, pageSize, statusKind, statusDescription);
        //封装对象
        returnData.setData(pageInfo);
        returnData.setCode(Code.OK);
        returnData.setMsg("获取成功");
        //返回
        return returnData;
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "productName", value = "商品名称", dataType = "String", paramType = "query", required = true)
    })
    @ApiOperation(value = "获取特定商品订单", notes = "获取特定商品订单")
    @PostMapping("/getOrdersByProduct")
    public ReturnData getOrdersByProduct(@RequestParam("productName") String productName
            , @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getOrdersByProductName(pageNum, pageSize, productName);
        //封装对象
        returnData.setData(pageInfo);
        returnData.setCode(Code.OK);
        returnData.setMsg("获取成功");

        //返回
        return returnData;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "time1", value = "时间1", dataType = "Timestamp", paramType = "query", required = true),
            @ApiImplicitParam(name = "time2", value = "时间2", dataType = "Timestamp", paramType = "query", required = true)
    })
    @ApiOperation(value = "获取特定日期订单", notes = "获取特定日期订单")
    @PostMapping("/getOrdersByDates")
    public ReturnData getOrdersBtDates(@RequestParam("time1") Timestamp time1, @RequestParam("time2") Timestamp time2
            , @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        log.info("\n"+time1 + "\n" + time2);
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getOrdersBtDates(time1, time2, pageNum, pageSize);
        //封装对象
        returnData.setData(pageInfo);
        returnData.setCode(Code.OK);
        returnData.setMsg("获取成功");
        //返回
        return returnData;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "userPhoneNumber", value = "用户手机号", dataType = "String", paramType = "query", required = true)
    })
    @ApiOperation(value = "获取特定用户的订单", notes = "获取特定用户的订单")
    @PostMapping("/getOrdersByUser")
    public ReturnData getOrdersByUser(@RequestParam("userPhoneNumber") String userPhoneNumber, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();

        //进行查询分页
        //查询用户
        User user = userService.getUserByPhoneNumber(userPhoneNumber);
        //查询订单
        PageInfo<Order> ordersByUserId = orderService.getOrdersByUserId(pageNum, pageSize, user.getUserId());

        //封装对象
        returnData.setData(ordersByUserId);
        returnData.setCode(Code.OK);
        returnData.setMsg("获取成功");

        return returnData;
    }


}
