package com.cust.trip.controller;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Product;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.KindService;
import com.cust.trip.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;
/**
 * @author GYF
 * @Data 2022.9.9
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    KindService kindService;

    @PostMapping("/addProduct")
    public ReturnData addProduct(@RequestBody Product product){
        int code = productService.addProduct(product);
        if (code == 0) {
            return new ReturnData(400, "产品已存在", null);
        } else if (code == 1) {
            return new ReturnData(200, "创建成功", null);
        } else {
            return new ReturnData(500, "服务器错误,请联系管理员", null);
        }
    }

    @DeleteMapping("/deleteProductByName")
    public ReturnData deleteProductByName(@RequestParam("productName") String productName){
        int code = productService.deleteProductByName(productName);
        if(code==0){
            return new ReturnData(400,"产品不存在",null);
        }else if(code==1){
            return new ReturnData(200,"删除成功",null);
        }else{
            return new ReturnData(500,"服务器错误,请联系管理员",null);
        }
    }

    @GetMapping("/selectAllProduct")
    public ReturnData selectAllProduct(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        PageInfo<Product> pageInfo = productService.selectAllProduct(pageNum,pageSize);
        return new ReturnData(200,"获取成功",pageInfo.getList());
    }

    @GetMapping("/selectAllProductByKind")
    public ReturnData selectAllProductByKind(@RequestParam String productKind,@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        Kind kind = kindService.selectKindByName(productKind);
        PageInfo<Product> pageInfo = productService.selectAllProductByKind(kind,pageNum,pageSize);
        return new ReturnData(200,"获取成功",pageInfo.getList());
    }

    @GetMapping("/selectProductByName")
    public ReturnData selectProductByName(@RequestParam("productName") String productName){
        Product product = productService.selectProductByName(productName);
        if(product==null){
            return new ReturnData(404,"产品不存在",null);
        }else{
            return new ReturnData(200,"获取成功",product);
        }
    }

}
