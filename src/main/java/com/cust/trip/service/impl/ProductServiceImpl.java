package com.cust.trip.service.impl;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Product;
import com.cust.trip.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Service
public class ProductServiceImpl implements ProductService {
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
    public List<Product> selectAllProductByKind(Kind kind) {
        return null;
    }

    @Override
    public List<Product> selectAllProductByPrice(double price1, double price2) {
        return null;
    }

    @Override
    public Product selectProductByName(String name) {
        return null;
    }

}
