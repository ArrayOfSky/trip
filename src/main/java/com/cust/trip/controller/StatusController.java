package com.cust.trip.controller;

import com.cust.trip.bean.Status;
import com.cust.trip.commom.CodeEnum;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.dao.StatusMapper;
import com.cust.trip.service.StatusService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GYF
 * @Data 2022.9.11
 */
@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    @RequestMapping("/addStatus")
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

    @RequestMapping("/deleteStatusByDescription")
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

    @RequestMapping("/selectAllStatus")
    public ReturnData selectAllStatus(@RequestParam int pageNum,@RequestParam int pageSize){
        PageInfo<Status> pageInfo = statusService.selectAllStatus(pageNum,pageSize);
        return new ReturnData(CodeEnum.OK,"获取成功",pageInfo.getList());
    }

    @RequestMapping("selectStatusByDescription")
    public ReturnData selectStatusByDescription(@RequestParam String statusDescription){
        Status status = statusService.selectStatusByDescription(statusDescription);
        if(status==null){
            return new ReturnData(CodeEnum.NOT_FOUND,"状态不存在",null);
        }else{
            return new ReturnData(CodeEnum.OK,"获取成功",status);
        }
    }










}
