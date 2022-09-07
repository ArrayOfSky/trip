package com.cust.trip.dao;

import com.cust.trip.bean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

@Mapper
public interface ProductMapper {

    List<Product> selectAllProduct();

    void insertProduct(Product product);

    void deleteProductByName(@Param("name") String productName);

    void updateProduct(Product product);

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
