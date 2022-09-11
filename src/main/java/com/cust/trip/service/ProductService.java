package com.cust.trip.service;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Product;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;


/**
 * @author GYF
 * @Data 2022.9.9
 */
@Service
public interface ProductService {
    /**
     * 添加产品
     * @param product 产品
     * @return 0 失败 1 成功 （后续修改）
     */
    int addProduct(Product product);

    /**
     * 根据姓名删除产品
     * @param productName 产品名称
     * @return 0 失败 1 成功 （后续修改）
     */
    int deleteProductByName(String productName);

    //    int updataProduct(String productName,Product product);

    /**
     * 分页查询所有产品
     * @param pageNum 第几页
     * @param pageSize 每页多少
     * @return 分页的产品
     */
    PageInfo<Product> selectAllProduct(int pageNum, int pageSize);

    /**
     * 根据类型 分页查询所有产品
     * @param kind 类型
     * @param pageNum 第几页
     * @param pageSize 每页多少
     * @return 分页的产品
     */
    PageInfo<Product> selectAllProductByKind(Kind kind,int pageNum,int pageSize);


//    List<Product> selectAllProductByPrice(double price1,double price2,int pageNum,int pageSize);

    /**
     * 根据姓名查询产品
     * @param productName 产品名称
     * @return 产品
     */
    Product selectProductByName(String productName);

}
