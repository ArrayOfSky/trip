package com.cust.trip.service.impl;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Product;
import com.cust.trip.dao.ProductMapper;
import com.cust.trip.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public int addProduct(Product product) {
        ArrayList<Product> array = (ArrayList<Product>) productMapper.selectAllProduct();
        for(Product a : array){
            if(a.getName().equals(product.getName())){
                return 0;
            }
        }
        productMapper.insertProduct(product);
        return 1;
    }

    @Override
    public int deleteProductByName(String name) {
        productMapper.deleteProductByName(name);
        return 1;
    }

    @Override
    public int updataProduct(String name, Product product) {
        ArrayList<Product> array = (ArrayList<Product>) productMapper.selectAllProduct();
        for(Product a : array){
            if(a.getName().equals(product.getName())){
                if(product.getName()==null){
                    product.setName(a.getName());
                }
                if(product.getCreateTime()==null){
                    product.setCreateTime(a.getCreateTime());
                }
                product.setId(a.getId());






            }
        }
        return 0;
    }

    @Override
    public List<Product> selectAllProduct() {
        ArrayList<Product> array = (ArrayList<Product>) productMapper.selectAllProduct();
        return array;
    }

    @Override
    public List<Product> selectAllProductByKind(Kind kind) {
        ArrayList<Product> array = (ArrayList<Product>) productMapper.selectAllProduct();
        ArrayList<Product> arr = new ArrayList<>();
        for(Product a : array){

        }
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
