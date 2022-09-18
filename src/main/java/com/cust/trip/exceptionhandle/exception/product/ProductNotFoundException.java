package com.cust.trip.exceptionhandle.exception.product;

import com.cust.trip.commom.Code;
import com.cust.trip.exceptionhandle.exception.BaseException;

/**
 * @author gyx
 * 2022/9/18
 */
public class ProductNotFoundException extends BaseException {
    public ProductNotFoundException() {
        super("商品不存在", Code.INVALID_REQUEST);
    }

    public ProductNotFoundException(String message, Integer code) {
        super(message, code);
    }
}
