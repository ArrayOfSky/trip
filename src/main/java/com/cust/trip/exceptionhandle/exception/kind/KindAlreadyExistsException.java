package com.cust.trip.exceptionhandle.exception.kind;

import com.cust.trip.commom.Code;
import com.cust.trip.exceptionhandle.exception.BaseException;

/**
 * @author gyx
 * 2022/9/25
 */
public class KindAlreadyExistsException extends BaseException {
    public KindAlreadyExistsException() {
        super("此类型已经存在", Code.INVALID_REQUEST);
    }

    public KindAlreadyExistsException(String message, Integer code) {
        super(message, code);
    }
}
