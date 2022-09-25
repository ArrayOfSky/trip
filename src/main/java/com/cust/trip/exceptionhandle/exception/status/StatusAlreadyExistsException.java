package com.cust.trip.exceptionhandle.exception.status;

import com.cust.trip.commom.Code;
import com.cust.trip.exceptionhandle.exception.BaseException;

/**
 * @author gyx
 * 2022/9/25
 */
public class StatusAlreadyExistsException extends BaseException {
    public StatusAlreadyExistsException() {
        super("状态已经存在", Code.INVALID_REQUEST);
    }

    public StatusAlreadyExistsException(String message, Integer code) {
        super(message, code);
    }
}
