package com.cust.trip.controller;


import com.cust.trip.bean.Kind;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.impl.KindServiceImpl;
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
    KindServiceImpl kindService;

    @PostMapping("/{kindName}")
    public ReturnData addKind(@PathVariable("kindName") String kindName){
        Kind kind = new Kind();
        kind.setName(kindName);
        int code = kindService.addKind(kind);
        if(code==0){
            return new ReturnData(400,"种类已存在",null);
        }else if(code==1){
            return new ReturnData(200,"创建成功",null);
        }else{
            return new ReturnData(500,"服务器错误,请联系管理员",null);
        }
    }

    @DeleteMapping("/{kindName}")
    public ReturnData deleteKind(@PathVariable("kindName") String kindName){
        int code = kindService.deleteKind(kindName);
        if(code==0){
            return new ReturnData(400,"种类不存在",null);
        }else if(code==1){
            return new ReturnData(200,"删除成功",null);
        }else{
            return new ReturnData(500,"服务器错误,请联系管理员",null);
        }
    }

    @PutMapping("/{name1}/{name2}")
    public ReturnData updateKind(@PathVariable("name1") String name1,@PathVariable("name2") String name2){
        int code = kindService.updateKind(name1,name2);
        if(code==0){
            return new ReturnData(400,"种类不存在",null);
        }else if(code==1){
            return new ReturnData(200,"修改成功",null);
        }else{
            return new ReturnData(500,"服务器错误,请联系管理员",null);
        }
    }

    @GetMapping("/{pageNum}/{pageSize}")
    public ReturnData selectAllKind(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        PageInfo<Kind> pageInfo = kindService.selectAllKind(pageNum,pageSize);
        ReturnData returnData = new ReturnData(200,"获取成功",pageInfo.getList());
        return returnData;
    }

    @GetMapping("/{kindName}")
    public ReturnData selectAllKindByName(@PathVariable("kindName") String kindName){
        Kind kind = kindService.selectKindByName(kindName);
        if(kind==null){
          return new ReturnData(400,"种类不存在",null);
        }else{
          return new ReturnData(200,"获取成功",kind);
        }
    }



}
