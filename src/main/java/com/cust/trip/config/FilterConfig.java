package com.cust.trip.config;

import com.cust.trip.filter.BaseFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GYF
 * @Data 2022.9.12
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new BaseFilter());
        //过滤所有路径
        registrationBean.addUrlPatterns("/*");
        //添加不过滤路径
        registrationBean.addInitParameter("noFilter","/trip/swagger2-ui.html");
        registrationBean.setName("BaseFilter");
        return registrationBean;
    }



}
