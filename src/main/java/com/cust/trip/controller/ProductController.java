package com.cust.trip.controller;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Product;
import com.cust.trip.commom.Code;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.KindService;
import com.cust.trip.service.ProductService;
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
@RequestMapping("/product")
@Api(value = "Product",tags = "产品模块")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    KindService kindService;

    @ApiImplicitParam(name = "product",value = "增加的产品",paramType = "body",dataType = "Product",required = true)
    @ApiOperation(notes = "添加产品",value = "添加产品")
    @PostMapping("/addProduct")
    public ReturnData addProduct(@RequestBody Product product){
        int code = productService.addProduct(product);
        if (code == 0) {
            return new ReturnData(Code.INVALID_REQUEST, "产品已存在", null);
        } else if (code == 1) {
            return new ReturnData(Code.CREATED, "创建成功", null);
        } else {
            return new ReturnData(Code.INTERNAL_SERVER_ERROR, "服务器错误,请联系管理员", null);
        }
    }

    @ApiImplicitParam(name = "productName",value = "产品名称",paramType = "query",dataType = "String",required = true)
    @ApiOperation(notes = "删除产品",value = "删除产品")
    @DeleteMapping("/deleteProductByName")
    public ReturnData deleteProductByName(@RequestParam("productName") String productName){
        int code = productService.deleteProductByName(productName);
        if(code==0){
            return new ReturnData(Code.INVALID_REQUEST,"产品不存在",null);
        }else if(code==1){
            return new ReturnData(Code.CREATED,"删除成功",null);
        }else{
            return new ReturnData(Code.INTERNAL_SERVER_ERROR,"服务器错误,请联系管理员",null);
        }
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "第几页",dataType = "Integer",paramType = "query",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页数据量",dataType = "Integer",paramType = "query",required = true)
    })
    @ApiOperation(value = "分页查询所有产品",notes = "分页查询所有产品")
    @GetMapping("/selectAllProduct")
    public ReturnData selectAllProduct(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        PageInfo<Product> pageInfo = productService.selectAllProduct(pageNum,pageSize);
        return new ReturnData(Code.OK,"获取成功",pageInfo);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "productKind",value = "产品类型",dataType = "String",paramType = "query",required = true),
            @ApiImplicitParam(name = "pageNum",value = "第几页",dataType = "Integer",paramType = "query",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页数据量",dataType = "Integer",paramType = "query",required = true)
    })
    @ApiOperation(value = "查询指定类型产品",notes = "查询指定类型产品")
    @GetMapping("/selectAllProductByKind")
    public ReturnData selectAllProductByKind(@RequestParam String productKind,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        Kind kind = kindService.selectKindByName(productKind);
        PageInfo<Product> pageInfo = productService.selectAllProductByKind(kind,pageNum,pageSize);
        return new ReturnData(Code.OK,"获取成功",pageInfo);
    }

    @ApiImplicitParam(name = "productName",value = "产品名称",dataType = "String",paramType = "query",required = true)
    @ApiOperation(value = "查询指定名称产品",notes = "查询指定名称产品")
    @GetMapping("/selectProductByName")
    public ReturnData selectProductByName(@RequestParam("productName") String productName){
        Product product = productService.selectProductByName(productName);
        if(product==null){
            return new ReturnData(Code.NOT_FOUND,"产品不存在",null);
        }else{
            return new ReturnData(Code.OK,"获取成功",product);
        }
    }

}
