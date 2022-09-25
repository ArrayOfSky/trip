package com.cust.trip.exceptionhandle.exception.manager;

import com.cust.trip.commom.Code;
import com.cust.trip.exceptionhandle.exception.BaseException;

/**
 * @author gyx
 * 2022/9/25
 */
public class AccountInfoException extends BaseException {
    public AccountInfoException() {
        super("账号或密码不能为空!",Code.INVALID_REQUEST);
    }

    public AccountInfoException(String message, Integer code) {
        super(message, code);
    }
}
