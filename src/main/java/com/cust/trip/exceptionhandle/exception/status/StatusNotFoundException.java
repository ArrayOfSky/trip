package com.cust.trip.exceptionhandle.exception.status;

import com.cust.trip.commom.Code;
import com.cust.trip.exceptionhandle.exception.BaseException;

/**
 * @author gyx
 * 2022/9/18
 */
public class StatusNotFoundException extends BaseException {
    public StatusNotFoundException() {
        super("状态不存在", Code.INVALID_REQUEST);
    }

    public StatusNotFoundException(String message, Integer code) {
        super(message, code);
    }
}
