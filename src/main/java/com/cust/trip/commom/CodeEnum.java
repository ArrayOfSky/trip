package com.cust.trip.commom;

/**
 * @author GYF
 * @Data 2022.9.9
 */
public enum CodeEnum {
    /**
     * 服务器成功返回用户请求的数据
     */
    OK(200),
    /**
     * 用户新建或修改数据成功
     */
    CREATED(201),
    /**
     * 表示一个请求已经进入后台排队
     */
    ACCEPTED(202),
    /**
     * 用户删除数据成功
     */
    NO_CONTENT(204),
    /**
     * 用户发出请求有错误，服务器并未进行新建，删除数据
     */
    INVALID_REQUEST(400),
    /**
     * 用户无权限
     */
    UNAUTHORIZED(401),
    /**
     * 用户有权限，但访问禁止
     */
    FORBIDDEN(403),
    /**
     * 用户发出的请求是不存在记录
     */
    NOT_FOUND(404),
    /**
     * 服务器无该方法
     */
    METHOD_NOT_ALLOWED(405),
    /**
     * 用户请求格式不可得
     */
    NOT_ACCEPTABLE(406),
    /**
     * 用户请求的资源被永久删除
     */
    GONE(410),
    /**
     * 发生验证错误
     */
    UNPROCESSABLE_ENTITY(422),
    /**
     * 服务器发生错误
     */
    INTERNAL_SERVER_ERROR(500),
    ;

    private final Integer code;

    public Integer getCode(){
        return code;
    }

    CodeEnum(Integer code) {
        this.code = code;
    }
}
