package com.cust.trip.service;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Product;
import com.cust.trip.service.impl.ProductServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Service
public interface ProductService {
    /**
     * 添加产品
     * @param product
     * @return 0 失败 1 成功 （后续修改）
     */
    int addProduct(Product product);

    /**
     * 根据姓名删除产品
     * @param productName
     * @return 0 失败 1 成功 （后续修改）
     */
    int deleteProductByName(String productName);

    /**
     * 根据姓名更新产品
     * 使用动态sql
     * @param productName
     * @param product
     * @return 0 失败 1 成功 （后续修改）
     */
//    int updataProduct(String productName,Product product);

    /**
     * 分页查询所有产品
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Product> selectAllProduct(int pageNum, int pageSize);

    /**
     * 根据类型 分页查询所有产品
     * @param kind
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Product> selectAllProductByKind(Kind kind,int pageNum,int pageSize);


//    List<Product> selectAllProductByPrice(double price1,double price2,int pageNum,int pageSize);

    /**
     * 根据姓名查询产品
     * @param productName
     * @return 产品
     */
    Product selectProductByName(String productName);

}
