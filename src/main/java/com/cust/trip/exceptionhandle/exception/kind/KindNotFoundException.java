package com.cust.trip.exceptionhandle.exception.kind;

import com.cust.trip.commom.Code;
import com.cust.trip.exceptionhandle.exception.BaseException;

/**
 * @author gyx
 * 2022/9/25
 */
public class KindNotFoundException extends BaseException {
    public KindNotFoundException() {
        super("类型不存在", Code.INVALID_REQUEST);
    }

    public KindNotFoundException(String message, Integer code) {
        super(message, code);
    }
}
