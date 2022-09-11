package com.cust.trip.controller;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Product;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.service.KindService;
import com.cust.trip.service.ProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Delete;
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
@Api
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    KindService kindService;

    @PostMapping("/{productName}/{productQuantity}/{productPrice}/{productKind}/{productStatus}/{shlfTime}/{takedownTime}")
    public ReturnData addProduct(@PathVariable("productName") String productName, @PathVariable("productQuantity") int productQuantity,
                                 @PathVariable("productPrice") double productPrice, @PathVariable("productKind") String productKind,
                                 @PathVariable("productStatus") String productStatus, @PathVariable("shlfTime") Date shlfTime,
                                 @PathVariable("takedownTime") Date takedownTime) {
        Product product = new Product();
        product.setName(productName);
        product.setPrice(productPrice);
        product.setQuantity(productQuantity);
        Kind kind = kindService.selectKindByName(productKind);
        product.setKind(kind.getId());
        product.setStatus(1);//后续status表出来后再写
        product.setTakedownTime(new Timestamp(takedownTime.getTime()));
        product.setShlfTime(new Timestamp(shlfTime.getTime()));
        int code = productService.addProduct(product);
        if (code == 0) {
            return new ReturnData(400, "产品已存在", null);
        } else if (code == 1) {
            return new ReturnData(200, "创建成功", null);
        } else {
            return new ReturnData(500, "服务器错误,请联系管理员", null);
        }
    }

    @DeleteMapping("/{productName}")
    public ReturnData deleteProductByName(@PathVariable("productName") String productName){
        int code = productService.deleteProductByName(productName);
        if(code==0){
            return new ReturnData(400,"产品不存在",null);
        }else if(code==1){
            return new ReturnData(200,"删除成功",null);
        }else{
            return new ReturnData(500,"服务器错误,请联系管理员",null);
        }
    }

    @GetMapping("/{pageNum}/{pageSize}")
    public ReturnData selectAllProduct(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        PageInfo<Product> pageInfo = productService.selectAllProduct(pageNum,pageSize);
        return new ReturnData(200,"获取成功",pageInfo.getList());
    }

    @GetMapping("/{productKind}/{pageNum}/{pageSize}")
    public ReturnData selectAllProductByKind(@PathVariable String productKind,@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        Kind kind = kindService.selectKindByName(productKind);
        PageInfo<Product> pageInfo = productService.selectAllProductByKind(kind,pageNum,pageSize);
        return new ReturnData(200,"获取成功",pageInfo.getList());
    }

    @GetMapping("/{productName}")
    public ReturnData selectProductByName(@PathVariable("productName") String productName){
        Product product = productService.selectProductByName(productName);
        if(product==null){
            return new ReturnData(404,"产品不存在",null);
        }else{
            return new ReturnData(200,"获取成功",product);
        }
    }
//    @PutMapping("/{}") 更新暂时不提供
}
