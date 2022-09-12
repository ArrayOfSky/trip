package com.cust.trip.controller;

import com.cust.trip.commom.Code;
import com.cust.trip.bean.Kind;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.KindService;
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
 * @Data 2022.9.9
 */
@RestController
@RequestMapping("/kind")
@Api(value = "Kind", tags = "类型模块")
@Slf4j
public class KindController {

    @Autowired
    KindService kindService;

    @PostMapping("/addKind")
    @ApiImplicitParam(name = "kind",value = "新增类型数据",dataType = "Kind",required = true,paramType = "body")
    @ApiOperation(value = "添加类型",notes = "添加类型")
    public ReturnData addKind(@RequestBody Kind kind) {
        int code = kindService.addKind(kind);
        if (code == 0) {
            return new ReturnData(Code.INVALID_REQUEST, "种类已存在", null);
        } else if (code == 1) {
            return new ReturnData(Code.CREATED, "创建成功", null);
        } else {
            return new ReturnData(Code.INTERNAL_SERVER_ERROR, "服务器错误,请联系管理员", null);
        }
    }

    @ApiImplicitParam(name = "kind",value = "删除的数据类型",dataType = "kind",required = true,paramType = "body")
    @ApiOperation(value = "删除类型",notes = "删除类型")
    @PostMapping("/deleteKind")
    public ReturnData deleteKind(@RequestBody Kind kind) {
        int code = kindService.deleteKind(kind.getKindName());
        if (code == 0) {
            return new ReturnData(Code.INVALID_REQUEST, "种类不存在", null);
        } else if (code == 1) {
            return new ReturnData(Code.CREATED, "删除成功", null);
        } else {
            return new ReturnData(Code.INTERNAL_SERVER_ERROR, "服务器错误,请联系管理员", null);
        }
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "kindName1",value = "需要修改的类型名",dataType = "String",required = true,paramType = "query"),
            @ApiImplicitParam(name = "kindName2",value = "修改后的类型名",dataType = "String",required = true,paramType = "query")
    })
    @ApiOperation(value = "修改类型",notes = "修改类型")
    @PostMapping("/updateKind")
    public ReturnData updateKind(@RequestParam("kindName1") String kindName1, @RequestParam("kindName2") String kindName2) {
        int code = kindService.updateKind(kindName1, kindName2);
        if (code == 0) {
            return new ReturnData(Code.INVALID_REQUEST, "种类不存在", null);
        } else if (code == 1) {
            return new ReturnData(Code.CREATED, "修改成功", null);
        } else {
            return new ReturnData(Code.INTERNAL_SERVER_ERROR, "服务器错误,请联系管理员", null);
        }
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "第几页",dataType = "Integer",required = true,paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页数据量",dataType = "Integer",required = true,paramType = "query")
    })
    @ApiOperation(value = "分页查找所有类型",notes = "分页查找所有类型")
    @PostMapping("/selectAllKind")
    public ReturnData selectAllKind(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        PageInfo<Kind> pageInfo = kindService.selectAllKind(pageNum, pageSize);
        return new ReturnData(Code.OK, "获取成功", pageInfo);
    }

    @ApiImplicitParam(name = "kindName",value = "查找的类型名称",dataType = "String",required = true,paramType = "query")
    @ApiOperation(value = "查找指定类型名称类型",notes = "查找知道类型名称类型")
    @PostMapping("/selectAllKindByName")
    public ReturnData selectAllKindByName(@RequestParam("kindName") String kindName) {
        Kind kind = kindService.selectKindByName(kindName);
        if (kind == null) {
            return new ReturnData(Code.NOT_FOUND, "种类不存在", null);
        } else {
            return new ReturnData(Code.OK, "获取成功", kind);
        }
    }
}
