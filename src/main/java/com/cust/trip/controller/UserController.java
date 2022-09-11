package com.cust.trip.controller;

import com.cust.trip.bean.Order;
import com.cust.trip.bean.User;
import com.cust.trip.commom.CodeEnum;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.UserService;
import com.cust.trip.utils.UserForm;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * @param pageSize 页面大小
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
        returnData.setData(pageInfo);
        returnData.setCode(CodeEnum.REQUEST_SUCCEED.getCode());
        returnData.setMsg("获取成功");
        //返回
        return returnData;
    }

    /**
     * 用手机号检索用户
     * @param phoneNumber 手机号码
     * @return data
     */
    @GetMapping("phone/{phoneNumber}")
    public ReturnData getUserByPhoneNumber(@PathVariable("phoneNumber")String phoneNumber){
        //创建返回对象
        ReturnData returnData = new ReturnData();
        final long length=11;
        //检查手机号格式
        if(phoneNumber.length()!=length){
            returnData.setMsg("号码格式不正确");
            returnData.setCode(401);
        }
        else{
            //正确则进行查询
            User user = userService.getUserByPhoneNumber(phoneNumber);
            returnData.setData(user);
            returnData.setCode(200);
            returnData.setMsg("获取成功");
        }
        return returnData;

    }

    /**
     * 据用户名获取用户信息
     * @param name 用户名
     * @return data
     */
    @GetMapping("name/{name}")
    public ReturnData getUserByName(@PathVariable("name") String name){
        //查询用户对象
        List<User> users = userService.getUserByName(name);
        ReturnData returnData=new ReturnData();
        //检查是否查到用户
        if(users.size()==0){
            //没有用户
            returnData.setMsg("找不到此用户");
            returnData.setCode(401);
        }
        else{
            //查找到了用户
            returnData.setMsg("获取成功");
            returnData.setCode(200);
            returnData.setData(users);
        }
        return returnData;
    }

    @GetMapping("/form/{form}/{pageNum}/{pageSize}")
    public ReturnData getUsersByForm(@PathVariable("form")UserForm form
    ,int pageNum,int pageSize){
        ReturnData returnData = new ReturnData();

        return returnData;
    }
}
