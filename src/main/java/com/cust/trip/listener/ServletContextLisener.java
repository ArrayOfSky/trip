package com.cust.trip.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/** 可以用来加缓存数据
 * @author GYF
 * @Data 2022.9.12
 */
@Component
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
