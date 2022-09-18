package com.cust.trip.exceptionhandle.exception.user;

import com.cust.trip.commom.Code;
import com.cust.trip.exceptionhandle.exception.BaseException;

/**
 * @author gyx
 * 2022/9/18
 */
public class NotFoundUserException extends BaseException {
    private static final long serialVersionUID=1231L;

    public NotFoundUserException(){
        super("用户不存在", Code.GONE);
    }

    public NotFoundUserException(String message,Integer code) {
        super(message,code);
    }
}
