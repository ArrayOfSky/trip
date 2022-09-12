package com.cust.trip.controller;

import com.cust.trip.bean.Status;
import com.cust.trip.commom.CodeEnum;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.StatusService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author GYF
 * @Data 2022.9.11
 */
@RestController
@RequestMapping("/status")
@Api(value = "Status",tags = "状态模块")
public class StatusController {

    @Autowired
    StatusService statusService;

    @ApiImplicitParam(name = "status",value = "状态",required = true,paramType = "body",dataType = "Status")
    @ApiOperation(value = "添加状态",notes = "添加状态")
    @PostMapping("/addStatus")
    public ReturnData addStatus(@RequestBody Status status){
        int code = statusService.insertStatus(status);
        if (code == 0) {
            return new ReturnData(CodeEnum.INVALID_REQUEST, "状态已存在", null);
        } else if (code == 1) {
            return new ReturnData(CodeEnum.CREATED, "创建成功", null);
        } else {
            return new ReturnData(CodeEnum.INTERNAL_SERVER_ERROR, "服务器错误,请联系管理员", null);
        }
    }

    @ApiImplicitParam(name = "statusDescription",value = "状态名",required = true,paramType = "query",dataType = "String")
    @ApiOperation(value = "根据状态名删除状态",notes = "根据状态名删除状态")
    @DeleteMapping("/deleteStatusByDescription")
    public ReturnData deleteStatusByDescription(@RequestParam String statusDescription){
        int code = statusService.deleteStatusByDescription(statusDescription);
        if (code == 0) {
            return new ReturnData(CodeEnum.INVALID_REQUEST, "状态不存在", null);
        } else if (code == 1) {
            return new ReturnData(CodeEnum.CREATED, "删除成功", null);
        } else {
            return new ReturnData(CodeEnum.INTERNAL_SERVER_ERROR, "服务器错误,请联系管理员", null);
        }
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageNum",value = "第几页",dataType = "Integer",required = true,paramType = "query"),
        @ApiImplicitParam(name = "pageSize",value = "每页数据量",dataType = "Integer",required = true,paramType = "query")
    })
    @ApiOperation(value = "分页查询所有状态",notes = "分页查询所有状态")
    @GetMapping("/selectAllStatus")
    public ReturnData selectAllStatus(@RequestParam int pageNum,@RequestParam int pageSize){
        PageInfo<Status> pageInfo = statusService.selectAllStatus(pageNum,pageSize);
        return new ReturnData(CodeEnum.OK,"获取成功",pageInfo);
    }

    @ApiImplicitParam(name = "statusDescription",value = "状态名称",required = true,dataType = "String",paramType = "query")
    @ApiOperation(value = "根据姓名查询状态",notes = "根据姓名查询状态")
    @GetMapping("selectStatusByDescription")
    public ReturnData selectStatusByDescription(@RequestParam String statusDescription){
        Status status = statusService.selectStatusByDescription(statusDescription);
        if(status==null){
            return new ReturnData(CodeEnum.NOT_FOUND,"状态不存在",null);
        }else{
            return new ReturnData(CodeEnum.OK,"获取成功",status);
        }
    }










}
