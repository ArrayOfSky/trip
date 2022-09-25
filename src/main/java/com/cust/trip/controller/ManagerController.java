package com.cust.trip.controller;

import com.cust.trip.bean.Manager;
import com.cust.trip.commom.Code;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.ManagerService;
import com.cust.trip.utils.JwtUtil;
import com.cust.trip.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author GYF
 * @Data 2022.9.14
 */
@RestController
@RequestMapping("/manager")
@Api(value = "Manager", tags = "管理员模块")
@Slf4j
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @Autowired
    RedisUtil redisUtil;


    @PostMapping("/login")
    @ApiImplicitParam(name = "manager",value = "管理员",dataType = "Manager",required = true,paramType = "body")
    @ApiOperation(value = "登陆",notes = "登陆")
    public ReturnData managerLogin(@RequestBody Manager manager, HttpServletRequest request){
        String token1 = request.getHeader("TOKEN");
        Object managerAccount = redisUtil.get("TOKEN" + token1);
        if (token1 == null || "".equals(token1.trim()) || managerAccount == null || "".equals(managerAccount.toString())) {
            managerService.login(manager);
                //生成token 设置缓存
                String token = JwtUtil.createToken(manager.getManagerAccount());
                redisUtil.setByHours("TOKEN"+token,manager.getManagerAccount(),(long)1);
                //返回token
                return new ReturnData(Code.OK,"登录成功",token);
        }else{
            return new ReturnData(Code.OK,"登录成功",null);
        }
    }



}
