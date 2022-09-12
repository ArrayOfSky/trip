//package com.cust.trip.listener;
//
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;
//
///** 统计在线人数
// * @author GYF
// * @Data 2022.9.12
// */
//@Component
//public class HttpSessionLisener implements HttpSessionListener {
//
//    private long count = 0;
//
//    @Override
//    public synchronized void sessionCreated(HttpSessionEvent httpSessionEvent) {
//        count++;
//        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
//    }
//
//    @Override
//    public synchronized void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
//        count--;
//        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
//    }
//
//}
