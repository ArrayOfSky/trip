package com.cust.trip.Listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author GYF
 * @Data 2022.9.12
 */
public class ServletContextLisener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 先获取到application上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
//        // 获取对应的service
//        UserService userService = applicationContext.getBean(UserService.class);
//        User user = userService.getUser();
//        // 获取application域对象，将查到的信息放到application域中
//        ServletContext application = applicationContext.getBean(ServletContext.class);
//        application.setAttribute("user", user);
    }
}
