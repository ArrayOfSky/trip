package com.cust.trip.listener.status;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author GYF
 * @Data 2022.9.12
 */
public class StatusEvent extends ApplicationEvent {
    public StatusEvent(Object source) {
        super(source);
    }

    public StatusEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
