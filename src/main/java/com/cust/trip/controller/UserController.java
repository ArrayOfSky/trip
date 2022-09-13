package com.cust.trip.controller;


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
@Api(value="User",tags="用户模块")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query", required = true)
    })
    @ApiOperation(value = "分页查询所有用户", notes = "分页查询所有用户")
    @PostMapping("/getAllUsers")
    public ReturnData getAllOrders(@RequestParam("pageNum") int pageNum
            , @RequestParam("pageSize") int pageSize) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        //获取分页信息
        PageInfo<User> pageInfo = userService.getAllUsers(pageNum, pageSize);
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
    @ApiOperation(value = "根据手机号查询用户", notes = "根据手机号查询用户")
    @PostMapping("getUserByPhoneNumber")
    public ReturnData getUserByPhoneNumber(@RequestParam("phoneNumber") String userPhoneNumber) {
        //创建返回对象
        ReturnData returnData = new ReturnData();
        final long length = 11;
        //检查手机号格式
        if (userPhoneNumber.length() != length) {
            returnData.setMsg("号码格式不正确");
            returnData.setCode(Code.UNPROCESSABLE_ENTITY);
        } else {
            //正确则进行查询
            User user = userService.getUserByPhoneNumber(userPhoneNumber);
            returnData.setData(user);
            returnData.setCode(Code.OK);
            returnData.setMsg("获取成功");
        }
        return returnData;

    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页数据量", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", paramType = "query", required = true)

    })
    @ApiOperation(value = "根据用户名查询用户", notes = "根据用户名查询用户")
    @PostMapping("/getUserByName")
    public ReturnData getUserByName(@RequestParam("userName") String userName) {
        //查询用户对象
        List<User> users = userService.getUserByName(userName);
        ReturnData returnData = new ReturnData();
        //检查是否查到用户
        if (users.size() == 0) {
            //没有用户
            returnData.setMsg("找不到此用户");
            returnData.setCode(Code.NOT_FOUND);
        } else {
            //查找到了用户
            returnData.setMsg("获取成功");
            returnData.setCode(Code.OK);
            returnData.setData(users);
        }
        return returnData;
    }


}
