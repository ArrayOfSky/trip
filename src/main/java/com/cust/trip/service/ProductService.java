package com.cust.trip.service;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Product;
import com.cust.trip.service.impl.ProductServiceImpl;
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
     * @param name
     * @return 0 失败 1 成功 （后续修改）
     */
    int deleteProductByName(String name);

    /**
     * 根据姓名更新产品
     * @param name
     * @param product
     * @return 0 失败 1 成功 （后续修改）
     */
    int updataProduct(String name,Product product);

    /**
     * 查询所有产品
     * @return 产品清单
     */
    List<Product> selectAllProduct();

    /**
     * 根据类型查询产品
     * @param kind
     * @return 产品清单
     */
    List<Product> selectAllProductByKind(Kind kind);

    /**
     * 根据价格区间查询产品
     * @param price1 下限价格
     * @param price2 上限价格
     * @return 产品清单
     */
    List<Product> selectAllProductByPrice(double price1,double price2);

    /**
     * 根据姓名查询产品
     * @param name
     * @return 产品
     */
    Product selectProductByName(String name);

}
