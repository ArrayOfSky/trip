package com.cust.trip.commom;

/**
 * @author HUAWEI
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
    SYSTEM_ERROR(501),
    ;

    private Integer code;

    CodeEnum(Integer code) {
        this.code = code;
    }
}
