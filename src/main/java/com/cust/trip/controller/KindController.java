package com.cust.trip.controller;


import com.cust.trip.bean.Kind;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.KindService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@RestController
@RequestMapping("/kind")
public class KindController {

    @Autowired
    KindService kindService;

//    @PathVariable("kindName")
    @PostMapping("/addKind")
    public ReturnData addKind(@RequestBody Kind kind) {
        int code = kindService.addKind(kind);
        if (code == 0) {
            return new ReturnData(400, "种类已存在", null);
        } else if (code == 1) {
            return new ReturnData(200, "创建成功", null);
        } else {
            return new ReturnData(500, "服务器错误,请联系管理员", null);
        }
    }

    @DeleteMapping("/deleteKind")
    public ReturnData deleteKind(@RequestBody Kind kind) {
        int code = kindService.deleteKind(kind.getKindName());
        if (code == 0) {
            return new ReturnData(400, "种类不存在", null);
        } else if (code == 1) {
            return new ReturnData(200, "删除成功", null);
        } else {
            return new ReturnData(500, "服务器错误,请联系管理员", null);
        }
    }

    @PutMapping("/updateKind")
    public ReturnData updateKind(@RequestParam("kindName1") String kindName1, @RequestParam("kindName2") String kindName2) {
        int code = kindService.updateKind(kindName1, kindName2);
        if (code == 0) {
            return new ReturnData(400, "种类不存在", null);
        } else if (code == 1) {
            return new ReturnData(200, "修改成功", null);
        } else {
            return new ReturnData(500, "服务器错误,请联系管理员", null);
        }
    }

    @GetMapping("/selectAllKind")
    public ReturnData selectAllKind(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        PageInfo<Kind> pageInfo = kindService.selectAllKind(pageNum, pageSize);
        return new ReturnData(200, "获取成功", pageInfo.getList());
    }

    @GetMapping("/selectAllKindByName")
    public ReturnData selectAllKindByName(@RequestParam("kindName") String kindName) {
        Kind kind = kindService.selectKindByName(kindName);
        if (kind == null) {
            return new ReturnData(404, "种类不存在", null);
        } else {
            return new ReturnData(200, "获取成功", kind);
        }
    }
}
