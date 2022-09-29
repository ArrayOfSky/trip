package com.cust.trip.controller;


import com.cust.trip.bean.Order;
import com.cust.trip.bean.User;
import com.cust.trip.commom.Code;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gyx
 * 2022/9/11
 */
@RestController
@RequestMapping("/user")
@Api(value = "User", tags = "用户模块")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "int", paramType = "query", required = true)
    })
    @ApiOperation(value = "分页查询所有用户", notes = "分页查询所有用户")
    @PostMapping("/getAllUsers")
    public ReturnData getAllOrders(@RequestParam("pageNum") int pageNum
            , @RequestParam("pageSize") int pageSize) {
        //获取分页信息
        PageInfo<User> pageInfo = userService.getAllUsers(pageNum, pageSize);
        return new ReturnData(Code.OK,"获取成功",pageInfo);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "userPhoneNumber", value = "用户手机号", dataType = "String", paramType = "query", required = true)

    })
    @ApiOperation(value = "根据手机号查询用户", notes = "根据手机号查询用户")
    @PostMapping("getUserByPhoneNumber")
    public ReturnData getUserByPhoneNumber(@RequestParam("userPhoneNumber") String userPhoneNumber, @RequestParam("pageNum") int pageNum
            , @RequestParam("pageSize") int pageSize) {
        PageInfo<User> userPageInfo = userService.getUserByPhoneNumber(userPhoneNumber, pageNum, pageSize);
        return new ReturnData(Code.OK,"获取成功",userPageInfo);

    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", paramType = "query", required = true)

    })
    @ApiOperation(value = "根据用户名查询用户", notes = "根据用户名查询用户")
    @PostMapping("/getUserByName")
    public ReturnData getUserByName(@RequestParam("userName") String userName,
                                    @RequestParam("pageSize") int pageSize,@RequestParam("pageNum") int pageNum) {
        //查询用户对象
        PageInfo<User> users = userService.getUserByName(userName, pageNum, pageSize);
        return new ReturnData(Code.OK,"获取成功",users);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name="user",value="用户",dataType="User",paramType="body",required=true)
    })
    @ApiOperation(value="用户注册",notes="传用户对象（除id）,json对象里面的时间格式yyyy-MM-dd'T'HH:mm:ss.SSSX,例如2022-09-20T00:00:00")
    @ApiImplicitParam(value="user" )
    @PostMapping("/register")
    public ReturnData registerUser(@RequestBody User user){
        userService.register(user);
        return new ReturnData(Code.OK,"注册成功",null);
    }

    @ApiImplicitParam(name = "user", value = "用户", dataType = "User", paramType = "body", required = true)
    @ApiOperation(value = "请忽略我", notes = "请忽略我")
    @PostMapping("/ignore")
    public String testUser(@RequestBody User user) {
        return null;
    }
}
