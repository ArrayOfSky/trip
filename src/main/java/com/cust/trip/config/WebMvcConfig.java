package com.cust.trip.config;

import com.cust.trip.Interceptor.ManagerLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author GYF
 * @Data 2022.9.12
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ManagerLoginInterceptor managerLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 增加要注册的拦截器类
        registry.addInterceptor(managerLoginInterceptor)
                .excludePathPatterns("/manager/login");
    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
