package com.cust.trip.service.impl;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Product;
import com.cust.trip.bean.Status;
import com.cust.trip.dao.KindMapper;
import com.cust.trip.dao.ProductMapper;
import com.cust.trip.dao.StatusMapper;
import com.cust.trip.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Service
@Transactional(rollbackFor=Exception.class)
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    KindMapper kindMapper;
    @Autowired
    StatusMapper statusMapper;

    @Override
    public int addProduct(Product product) {
        ArrayList<Product> array = (ArrayList<Product>) productMapper.selectAllProduct();
        for(Product a : array){
            if(a.getProductName().equals(product.getProductName())){
                return 0;
            }
        }
        Kind kind = kindMapper.selectKindByName(product.getKindName());
        Status status = statusMapper.selectStatusByName(product.getStatusName());
        productMapper.insertProduct(product,kind.getKindId(),status.getStatusId());
        return 1;
    }

    @Override
    public int deleteProductByName(String name) {
        productMapper.deleteProductByName(name);
        return 1;
    }

    @Override
    public PageInfo<Product> selectAllProduct(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> array = productMapper.selectAllProduct();
        System.out.println(array.get(0).getProductCreateTime());
        return new PageInfo<>(array);
    }

    @Override
    public PageInfo selectAllProductByKind(Kind kind,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ArrayList<Product> array = (ArrayList<Product>) productMapper.selectAllProduct();
        ArrayList<Product> arr = new ArrayList<>();
        for(Product a : array){
            if(a.getKindName().equals(kind.getKindName())){
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
