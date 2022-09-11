package com.cust.trip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@SpringBootApplication
@EnableWebMvc
public class TripApplication {
    public static void main(String[] args) {
        SpringApplication.run(TripApplication.class, args);
    }

}
