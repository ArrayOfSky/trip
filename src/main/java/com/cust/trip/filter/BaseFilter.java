package com.cust.trip.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author GYF
 * @Data 2022.9.16
 */
@Component
@Slf4j
public class BaseFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
//            log.error(servletRequest.getServerName()+"访问了过滤器");
            servletRequest.setCharacterEncoding("UTF-8");
            servletResponse.setCharacterEncoding("UTF-8");
            filterChain.doFilter(servletRequest,servletResponse);
        } catch (Exception e) {
            log.error("swagger error");
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
