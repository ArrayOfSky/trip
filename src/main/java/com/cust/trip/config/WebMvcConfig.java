package com.cust.trip.config;

import com.cust.trip.Interceptor.ManagerLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

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
                .addPathPatterns("/*")
                .excludePathPatterns("/manager/login")
                .excludePathPatterns("/swagger-ui.html");
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

    // 拦截器跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 跨域路径
        CorsRegistration cors = registry.addMapping("/**");

        // 可访问的外部域
        cors.allowedOrigins("*");
        // 支持跨域用户凭证
        //cors.allowCredentials(true);
        //cors.allowedOriginPatterns("*");
        // 设置 header 能携带的信息
        cors.allowedHeaders("*");
        // 支持跨域的请求方法
        cors.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
        // 设置跨域过期时间，单位为秒
        cors.maxAge(3600);
    }

}
