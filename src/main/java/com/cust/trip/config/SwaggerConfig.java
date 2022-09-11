package com.cust.trip.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableKnife4j
@Profile({"dev","test"})
public class SwaggerConfig implements WebMvcConfigurer {
    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
    //这个是方法2哦，使用的话在new Docket里添加.Enable方法将参数放入即可
    @Value(value = "${swagger.show}")
    private Boolean swaggerEnabled;

    @Bean
    public Docket createRestBmbsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("users")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cust.trip.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("趣旅行 api")
                .version("0.0.1")
                .build();
    }

}

