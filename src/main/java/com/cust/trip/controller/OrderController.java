//package com.cust.trip.controller;
//
//import com.cust.trip.bean.Order;
//import com.cust.trip.bean.Product;
//import com.cust.trip.bean.User;
//import com.cust.trip.commom.CodeEnum;
//import com.cust.trip.commom.ReturnData;
//import com.cust.trip.service.OrderService;
//import com.cust.trip.service.ProductService;
//import com.github.pagehelper.PageInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.Timestamp;
//import java.util.Date;
//
///**
// * @author gyx
// * 2022/9/11
// */
//@RestController
//@RequestMapping("/order")
//public class OrderController {
//
//    private OrderService orderService;
//
//    private ProductService productService;
//
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @Autowired
//    public void setOrderService(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    /**
//     * 显示全部订单
//     *
//     * @param pageNum  页数
//     * @param pageSize 页面大小
//     * @return data
//     */
//    @GetMapping("/{pageNum}/{pageSize}")
//    public ReturnData getAllOrders(@PathVariable("pageNum") int pageNum
//            , @PathVariable("pageSize") int pageSize) {
//        //创建返回对象
//        ReturnData returnData = new ReturnData();
//        //获取分页信息
//        PageInfo<Order> pageInfo = orderService.getAllOrdersForPage(pageNum, pageSize);
//        //封装对象
//        returnData.setData(pageInfo);
//        returnData.setCode(CodeEnum.REQUEST_SUCCEED.getCode());
//        returnData.setMsg("获取成功");
//        //返回
//        return returnData;
//    }
//
//    /**
//     * 筛选某一用户订单
//     *
//     * @param user     用户
//     * @param pageNum  页数
//     * @param pageSize 页面大小
//     * @return data
//     */
//    @GetMapping("/{user}/{pageNum}/{pageSize}")
//    public ReturnData getOrdersByUser(@PathVariable("user") User user
//            , @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
//        //创建返回对象
//        ReturnData returnData = new ReturnData();
//        //获取分页信息
//        PageInfo<Order> pageInfo = orderService.getOrdersByUser(pageNum, pageSize, user);
//        //封装对象
//        returnData.setData(pageInfo);
//        returnData.setCode(CodeEnum.REQUEST_SUCCEED.getCode());
//        returnData.setMsg("获取成功");
//        //返回
//        return returnData;
//    }
//
//    /**
//     * 筛选某一状态订单
//     *
//     * @param status   状态
//     * @param pageNum  页数
//     * @param pageSize 页面大小
//     * @return data
//     */
//    @GetMapping("/{status}/{pageNum}/{pageSize}")
//    public ReturnData getOrdersByStatus(@PathVariable("status") int status
//            , @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
//        //创建返回对象
//        ReturnData returnData = new ReturnData();
//        //获取分页信息
//        PageInfo<Order> pageInfo = orderService.getOrdersByStatus(pageNum, pageSize, status);
//        //封装对象
//        returnData.setData(pageInfo);
//        returnData.setCode(CodeEnum.REQUEST_SUCCEED.getCode());
//        returnData.setMsg("获取成功");
//        //返回
//        return returnData;
//    }
//
//    /**
//     * 获取某一商品的订单
//     *
//     * @param product  商品
//     * @param pageNum  页数
//     * @param pageSize 页面大小
//     * @return data
//     */
//    @GetMapping("/{product}/{pageNum}/{pageSize}")
//    public ReturnData getOrdersByProduct(@PathVariable("product") Product product
//            , @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
//        //创建返回对象
//        ReturnData returnData = new ReturnData();
//        //获取分页信息
//        PageInfo<Order> pageInfo = orderService.getOrdersByProductId(pageNum, pageSize, product.getProductId());
//        //封装对象
//        returnData.setData(pageInfo);
//        returnData.setCode(CodeEnum.REQUEST_SUCCEED.getCode());
//        returnData.setMsg("获取成功");
//        //返回
//        return returnData;
//    }
//
//    /**
//     * 获取某一时间段的订单
//     * @param time1    时间先
//     * @param time2    时间后
//     * @param pageNum  页数
//     * @param pageSize 页面大小
//     * @return data
//     */
//    @GetMapping("/{time1}/{time2}/{pageNum}/{pageSize}")
//    public ReturnData getOrdersBtDates(@PathVariable("time1") Date time1, @PathVariable("time2") Date time2
//            , @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
//        //创建返回对象
//        ReturnData returnData = new ReturnData();
//        //获取分页信息
//        PageInfo<Order> pageInfo = orderService.getOrdersBtDates(new Timestamp(time1.getTime()), new Timestamp(time2.getTime()), pageNum, pageSize);
//        //封装对象
//        returnData.setData(pageInfo);
//        returnData.setCode(CodeEnum.REQUEST_SUCCEED.getCode());
//        returnData.setMsg("获取成功");
//        //返回
//        return returnData;
//    }
//
//    /**
//     * 生成订单
//     * @param product 商品
//     * @param user 用户
//     * @return data
//     */
//    @PostMapping("/{product}/{user}")
//    public ReturnData order(@PathVariable("product") Product product,@PathVariable("user") User user){
//        //检查商品状态
//        return null;
//    }
//
//
//
//
//
//
//}
