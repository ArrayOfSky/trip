package com.cust.trip.exceptionhandle.exception.user;

import com.cust.trip.commom.Code;
import com.cust.trip.exceptionhandle.exception.BaseException;

/**
 * @author gyx
 * 2022/9/22
 */
public class UserExistedException extends BaseException {
    public UserExistedException() {
        super("此手机号已经被注册", Code.INVALID_REQUEST);
    }

    public UserExistedException(String message, Integer code) {
        super(message, code);
    }
}
