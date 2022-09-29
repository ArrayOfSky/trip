package com.cust.trip.exceptionhandle;

import com.cust.trip.commom.Code;
import com.cust.trip.commom.ReturnData;
import com.cust.trip.exceptionhandle.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.AccessDeniedException;

/**
 * @author GYF
 * @Data 2022.9.12
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 自定义异常处理
     * @param e 异常
     * @return 错误信息
     */
    @ExceptionHandler(BaseException.class)
    public ReturnData handleBaseException(BaseException e){
        return new ReturnData(e.getCode(),e.getMessage(),null);
    }


    /**
     *  全局异常处理
     * @param ex 异常
     * @return 错误信息
     */
    @ExceptionHandler(Exception.class)
    public ReturnData handleUnexpectedServer(Exception ex) {

        log.error(ex.getMessage());
        return new ReturnData(Code.INTERNAL_SERVER_ERROR,"服务器发生错误",ex.getMessage());
    }


    /**
     * 请求参数缺失异常处理
     * @param e 异常
     * @return 错误信息
     */
    @ExceptionHandler(MissingRequestValueException.class)
    public ReturnData handleMissingRequestValueException(MissingRequestValueException e){
        return new ReturnData(Code.INVALID_REQUEST,e.getMessage(),null);
    }


    /**
     * 权限不足异常处理
     * @param e 异常
     * @return 错误信息
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ReturnData handleAccessDeniedException(AccessDeniedException e){
        return new ReturnData(Code.FORBIDDEN,e.getMessage(),null);
    }




}
