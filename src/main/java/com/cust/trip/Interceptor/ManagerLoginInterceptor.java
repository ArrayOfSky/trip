package com.cust.trip.Interceptor;

import com.cust.trip.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GYF
 * @Data 2022.9.15
 */
@Component
@Slf4j
public class ManagerLoginInterceptor  implements HandlerInterceptor {

    @Autowired
    RedisUtil redisUtil;

    /**
     * 若未登录 或登录过期 不能访问其他页面
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.error(request.getRequestURI()+"访问了");
        return true;
//        String token = request.getHeader("token");
//        Object managerAccount = redisUtil.get("TOKEN" + token);
//        if (token == null || "".equals(token.trim()) || managerAccount == null||"".equals(managerAccount.toString())) {
//            return false;
//        }
//        return true;
    }

}
