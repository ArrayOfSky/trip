//package com.cust.trip.exception;
//
//import com.cust.trip.commom.CodeEnum;
//import com.cust.trip.commom.ReturnData;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
///**
// * @author GYF
// * @Data 2022.9.12
// */
//@ControllerAdvice
//@ResponseBody
//public class GlobalExceptionHandler {
//
//
//    /**
//     *  全局异常处理
//     * @param ex 异常
//     * @return 错误信息
//     */
//    @ExceptionHandler(Exception.class)
//    public ReturnData handleUnexpectedServer(Exception ex) {
//
//
//        return new ReturnData(CodeEnum.INTERNAL_SERVER_ERROR,"服务器错误",null);
//    }
//
//}
