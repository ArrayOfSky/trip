package com.cust.trip.service;

import com.cust.trip.bean.Product;
import com.cust.trip.service.impl.ProductServiceImpl;

import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */
public class ProductService implements ProductServiceImpl {


    @Override
    public int addProduct(Product product) {
        return 0;
    }

    @Override
    public int deleteProductByName(String name) {
        return 0;
    }

    @Override
    public int updataProduct(String name, Product product) {
        return 0;
    }

    @Override
    public List<Product> selectAllProduct() {
        return null;
    }

    @Override
    public Product selectProductByName(String name) {
        return null;
    }
}
