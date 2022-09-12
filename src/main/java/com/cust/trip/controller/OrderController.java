package com.cust.trip.controller;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.Product;
import com.cust.trip.bean.User;
import com.cust.trip.commom.CodeEnum;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.OrderService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
public class OrderController {

    private OrderService orderService;


    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query", required = true)
    })
    @ApiOperation(value = "分页查询所有订单", notes = "分页查询所有订单")
    @GetMapping("/getAllOrders")
    public ReturnData getAllOrders(@RequestParam("pageNum") int pageNum
            , @RequestParam("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getAllOrdersForPage(pageNum, pageSize);
        //封装对象
        returnData.setData(pageInfo);
        returnData.setCode(CodeEnum.OK.getCode());
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
    @GetMapping("/getOrdersByStatus")
    public ReturnData getOrdersByStatus(@RequestParam("statusKind") String statusKind, @RequestParam("statusDescription") String statusDescription
            , @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getOrdersByStatus(pageNum, pageSize, statusKind, statusDescription);
        //封装对象
        returnData.setData(pageInfo);
        returnData.setCode(CodeEnum.OK.getCode());
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
    @GetMapping("/getOrdersByProduct")
    public ReturnData getOrdersByProduct(@RequestParam("productName") String productName
            , @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getOrdersByProductName(pageNum, pageSize, productName);
        //封装对象
        returnData.setData(pageInfo);
        returnData.setCode(CodeEnum.OK.getCode());
        returnData.setMsg("获取成功");
        //返回
        return returnData;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "time1", value = "时间1", dataType = "Date", paramType = "query", required = true),
            @ApiImplicitParam(name = "time2", value = "时间2", dataType = "Date", paramType = "query", required = true)
    })
    @ApiOperation(value = "获取特定日期订单", notes = "获取特定日期订单")
    @GetMapping("/getOrdersByDates")
    public ReturnData getOrdersBtDates(@RequestParam("time1") Date time1, @RequestParam("time2") Date time2
            , @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<Order> pageInfo = orderService.getOrdersBtDates(new Timestamp(time1.getTime()), new Timestamp(time2.getTime()), pageNum, pageSize);
        //封装对象
        returnData.setData(pageInfo);
        returnData.setCode(CodeEnum.OK.getCode());
        returnData.setMsg("获取成功");
        //返回
        return returnData;
    }


}
