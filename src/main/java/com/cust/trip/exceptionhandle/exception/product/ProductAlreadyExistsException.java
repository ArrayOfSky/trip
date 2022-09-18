package com.cust.trip.exceptionhandle.exception.product;

import com.cust.trip.commom.Code;
import com.cust.trip.exceptionhandle.exception.BaseException;

/**
 * @author gyx
 * 2022/9/18
 */
public class ProductAlreadyExistsException extends BaseException {
    public ProductAlreadyExistsException(String message, Integer code) {
        super(message, code);
    }

    public ProductAlreadyExistsException() {
        super("商品重复添加", Code.INVALID_REQUEST);
    }
}
