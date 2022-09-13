package com.cust.trip.controller;

import com.cust.trip.bean.Status;
import com.cust.trip.commom.Code;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.StatusService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author GYF
 * @Data 2022.9.11
 */
@RestController
@RequestMapping("/status")
@Api(value = "Status",tags = "状态模块")
@Slf4j
public class StatusController {

    @Autowired
    StatusService statusService;

    @ApiImplicitParam(name = "status",value = "状态",required = true,paramType = "body",dataType = "Status")
    @ApiOperation(value = "添加状态",notes = "添加状态")
    @PostMapping("/addStatus")
    public ReturnData addStatus(@RequestBody Status status){
        System.out.println(status);
        int code = statusService.insertStatus(status);
        if (code == 0) {
            return new ReturnData(Code.INVALID_REQUEST, "状态已存在", null);
        } else if (code == 1) {
            return new ReturnData(Code.CREATED, "创建成功", null);
        } else {
            return new ReturnData(Code.INTERNAL_SERVER_ERROR, "服务器错误,请联系管理员", null);
        }
    }

    @ApiImplicitParam(name = "statusName",value = "状态名",required = true,paramType = "query",dataType = "String")
    @ApiOperation(value = "根据状态名删除状态",notes = "根据状态名删除状态")
    @PostMapping("/deleteStatusByName")
    public ReturnData deleteStatusByName(@RequestParam String statusName){
        int code = statusService.deleteStatusByName(statusName);
        if (code == 0) {
            return new ReturnData(Code.INVALID_REQUEST, "状态不存在", null);
        } else if (code == 1) {
            return new ReturnData(Code.CREATED, "删除成功", null);
        } else {
            return new ReturnData(Code.INTERNAL_SERVER_ERROR, "服务器错误,请联系管理员", null);
        }
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum",value = "第几页",dataType = "Integer",required = true,paramType = "query"),
        @ApiImplicitParam(name = "pageSize",value = "每页数据量",dataType = "Integer",required = true,paramType = "query")
    })
    @ApiOperation(value = "分页查询所有状态",notes = "分页查询所有状态")
    @PostMapping("/selectAllStatus")
    public ReturnData selectAllStatus(@RequestParam int pageNum,@RequestParam int pageSize){
        PageInfo<Status> pageInfo = statusService.selectAllStatus(pageNum,pageSize);
        return new ReturnData(Code.OK,"获取成功",pageInfo);
    }

    @ApiImplicitParam(name = "statusName",value = "状态名称",required = true,dataType = "String",paramType = "query")
    @ApiOperation(value = "根据姓名查询状态",notes = "根据姓名查询状态")
    @PostMapping("selectStatusByName")
    public ReturnData selectStatusByDescription(@RequestParam String statusName){
        Status status = statusService.selectStatusByName(statusName);
        if(status==null){
            return new ReturnData(Code.NOT_FOUND,"状态不存在",null);
        }else{
            return new ReturnData(Code.OK,"获取成功",status);
        }
    }










}
