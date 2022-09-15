package com.cust.trip.listener;

import com.cust.trip.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author GYF
 * @Data 2022.9.15
 */
@Slf4j
@Component
public class ManagerLoginCountListener implements HttpSessionListener {

    public static Integer count = 0;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("管理员上线了,目前人数:" + count);
        count++;
        redisUtil.set("count",count.toString());
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("管理员下线了,目前人数:" + count);
        count--;
        redisUtil.set("count",count.toString());
    }


}
