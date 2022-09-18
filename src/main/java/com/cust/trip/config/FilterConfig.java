package com.cust.trip.config;

import com.cust.trip.filter.BaseFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GYF
 * @Data 2022.9.16
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new BaseFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }


}
