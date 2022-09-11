package com.cust.trip.service.impl;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Product;
import com.cust.trip.dao.ProductMapper;
import com.cust.trip.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
            if(a.getProductName().equals(product.getProductName())){
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

//    @Override
//    public int updataProduct(String name, Product product) {
//        productMapper.updateProduct(name,product);
//        return 1;
//    }

    @Override
    public PageInfo<Product> selectAllProduct(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> array = productMapper.selectAllProduct();
        return new PageInfo<>(array);
    }

    @Override
    public PageInfo selectAllProductByKind(Kind kind,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Product> array = (ArrayList<Product>) productMapper.selectAllProduct();
        ArrayList<Product> arr = new ArrayList<>();
        for(Product a : array){
            if(a.getProductKind()==kind.getKindId()){
                arr.add(a);
            }
        }
        return new PageInfo<>(arr);
    }

    @Override
    public Product selectProductByName(String name) {
        ArrayList<Product> array = (ArrayList<Product>) productMapper.selectAllProduct();
        for(Product a : array){
            if(a.getProductName().equals(name)){
                return a;
            }
        }
        return null;
    }

}
