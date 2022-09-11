package com.cust.trip.controller;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.User;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gyx
 * 2022/9/11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 获取所有用户列表
     *
     * @param pageNum  页数
     * @param pageSize 总页数
     * @return data
     */
    @GetMapping("/{pageNum}/{pageSize}")
    public ReturnData getAllOrders(@PathVariable("pageNum") int pageNum
            , @PathVariable("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<User> pageInfo = userService.getAllUsers(pageNum, pageSize);
        //封装对象
        returnData.setData(pageInfo.getList());
        //返回
        return returnData;
    }
}
