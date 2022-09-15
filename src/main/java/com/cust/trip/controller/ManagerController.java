package com.cust.trip.controller;

import com.cust.trip.bean.Manager;
import com.cust.trip.commom.Code;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.ManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/login")
    @ApiImplicitParam(name = "manager",value = "管理员",dataType = "Manager",required = true,paramType = "body")
    @ApiOperation(value = "登陆",notes = "登陆")
    public ReturnData managerLogin(@RequestBody Manager manager){
        int code = managerService.login(manager);
        if(code==0){
            return new ReturnData(Code.INVALID_REQUEST,"登陆失败",null);
        }else if(code==1){
            return new ReturnData(Code.CREATED,"登陆成功",null);
        }else{
            return new ReturnData(Code.INTERNAL_SERVER_ERROR,"服务器错误,请联系管理员",null);
        }
    }



}
