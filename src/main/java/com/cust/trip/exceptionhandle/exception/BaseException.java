package com.cust.trip.exceptionhandle.exception;

/**
 * @author gyx
 * 2022/9/18
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID=1220L;

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BaseException(String message, Integer code) {
        super(message);
    }
}
