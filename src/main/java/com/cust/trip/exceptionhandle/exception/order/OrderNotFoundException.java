package com.cust.trip.exceptionhandle.exception.order;

import com.cust.trip.commom.Code;
import com.cust.trip.exceptionhandle.exception.BaseException;

/**
 * @author gyx
 * 2022/9/18
 */
public class OrderNotFoundException extends BaseException {
    public OrderNotFoundException(String message, Integer code) {
        super(message, code);
    }

    public OrderNotFoundException() {
        super("订单不存在", Code.INVALID_REQUEST);
    }
}
