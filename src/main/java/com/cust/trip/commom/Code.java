package com.cust.trip.commom;

/**
 * @author gyx
 * 2022/9/12
 */
public class Code {
    /**
     * 服务器成功返回用户请求的数据
     */
    public static final Integer OK = 200;
    /**
     * 用户新建或修改数据成功
     */
    public static final Integer CREATED = 201;
    /**
     * 表示一个请求已经进入后台排队
     */
    public static final Integer ACCEPTED = 202;
    /**
     * 用户删除数据成功
     */
    public static final Integer NO_CONTENT = 204;
    /**
     * 用户发出请求有错误，服务器并未进行新建，删除数据
     */
    public static final Integer INVALID_REQUEST = 400;
    /**
     * 用户无权限
     */
    public static final Integer UNAUTHORIZED = 401;
    /**
     * 用户有权限，但访问禁止
     */
    public static final Integer FORBIDDEN = 403;
    /**
     * 用户发出的请求是不存在记录
     */
    public static final Integer NOT_FOUND = 404;
    /**
     * 服务器无该方法
     */
    public static final Integer METHOD_NOT_ALLOWED = 405;
    /**
     * 用户请求格式不可得
     */
    public static final Integer NOT_ACCEPTABLE = 406;
    /**
     * 用户请求的资源被永久删除
     */
    public static final Integer GONE = 410;
    /**
     * 发生验证错误
     */
    public static final Integer UNPROCESSABLE_ENTITY = 422;
    /**
     * 服务器发生错误
     */
    public static final Integer INTERNAL_SERVER_ERROR = 500;
    ;
}
