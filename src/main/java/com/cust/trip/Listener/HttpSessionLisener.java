package com.cust.trip.Listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author GYF
 * @Data 2022.9.12
 */
public class HttpSessionLisener implements HttpSessionListener {

    private long count = 0;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count++;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
    }

}
