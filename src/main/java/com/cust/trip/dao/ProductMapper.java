package com.cust.trip.dao;

import com.cust.trip.bean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Mapper
public interface ProductMapper {
    /**
     * 查询所有产品
     * @return 产品列表
     */
    List<Product> selectAllProduct();

    /**
     * 增加产品
     * @param product 产品
     */
    void insertProduct(@Param("product") Product product,@Param("productKind") int productKind);

    /**
     * 删除产品根据产品名
     * @param productName 产品名
     */
    void deleteProductByName(@Param("productName") String productName);

    /**
     * 更新产品
     * @param product
     * @param name
     */
//    void updateProduct(@Param("productName") String name,Product product);

//    void updateProductStock(String name,Integer stock);
//
//    void updateProductQuantity(String name,Integer quantity);
//
//    void updateProductSales(String name,Integer sale);
//
//    void updateProductPrice(String name,Double Price);
//
//    void updateProductKind(String name,int kind);
//
//    void updateProductStatus(String name,int status);
//
//    void updateProductCreateTime(String name, Date time);
//
//    void updateProductUpdateTime(String name,Date time);
//
//    void updateProductShlfTime(String name,Date time);
//
//    void updateProductTakeDownTime(String name,Date time);

}
