package com.cust.trip.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author GYF
 * @Data 2022.9.12
 */
public class StatusFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}