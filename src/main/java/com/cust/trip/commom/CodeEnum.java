package com.cust.trip.commom;

/**
 * @author GYF
 * @Data 2022.9.9
 */
public enum CodeEnum {
    /**
     * 请求成功
     */
    REQUEST_SUCCEED(200),

    /**
     * 请求失败
     */
    REQUEST_FAILED(401),
    /**
     * 访问路径不存在
     */
    URI_NOT_EXIST(404),
    /**
     * 系统错误
     */
    SYSTEM_ERROR(500),
    ;

    private final Integer code;

    public Integer getCode(){
        return code;
    }

    CodeEnum(Integer code) {
        this.code = code;
    }
}
