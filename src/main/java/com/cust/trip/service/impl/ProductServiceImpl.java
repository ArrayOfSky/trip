package com.cust.trip.service.impl;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.Product;
import com.cust.trip.bean.Status;
import com.cust.trip.commom.Code;
import com.cust.trip.dao.KindMapper;
import com.cust.trip.dao.ProductMapper;
import com.cust.trip.dao.StatusMapper;
import com.cust.trip.exceptionhandle.exception.kind.KindNotFoundException;
import com.cust.trip.exceptionhandle.exception.product.ProductAlreadyExistsException;
import com.cust.trip.exceptionhandle.exception.product.ProductNotFoundException;
import com.cust.trip.exceptionhandle.exception.status.StatusNotFoundException;
import com.cust.trip.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "product")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    KindMapper kindMapper;
    @Autowired
    StatusMapper statusMapper;

    @Override
    @CacheEvict(cacheNames = "product",allEntries = true)
    public void addProduct(Product product) {
        ArrayList<Product> array = (ArrayList<Product>) productMapper.selectAllProduct();
        for(Product a : array){
            if(a.getProductName().equals(product.getProductName())){
                throw new ProductAlreadyExistsException();
            }
        }
        Kind kind = kindMapper.selectKindByName(product.getKindName());
        if(kind==null){
            throw new KindNotFoundException();
        }
        Status status = statusMapper.selectStatusByName(product.getStatusName());
        if(status==null){
            throw new StatusNotFoundException();
        }
        productMapper.insertProduct(product,kind.getKindId(),status.getStatusId());
    }

    @Override
    @CacheEvict(cacheNames = "product",allEntries = true)
    public void deleteProductByName(String name) {
        int code=productMapper.deleteProductByName(name);
        if(code==0){
            throw new ProductNotFoundException("产品不存在，删除失败", Code.INVALID_REQUEST);
        }
    }

    @Override
    //@Cacheable(key = "'selectAllProduct'+#pageNum+#pageSize")
    public PageInfo<Product> selectAllProduct(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> array = productMapper.selectAllProduct();
        return new PageInfo<>(array);
    }

    @Override
    @Cacheable(key = "'selectAllProductByKind'+#kind.kindName+#pageNum+#pageSize")
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
    @Cacheable(key = "'selectProductByName'+#name")
    public Product selectProductByName(String name) {
        ArrayList<Product> array = (ArrayList<Product>) productMapper.selectAllProduct();
        for(Product a : array) {
            if(a.getProductName().equals(name)){
                return a;
            }
            if (a.getProductName().contains(name)) {
                return a;
            }

        }
        return null;
    }

}
