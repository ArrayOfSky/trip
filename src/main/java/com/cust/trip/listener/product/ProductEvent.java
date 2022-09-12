package com.cust.trip.listener.product;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author GYF
 * @Data 2022.9.12
 */
public class ProductEvent extends ApplicationEvent {
    public ProductEvent(Object source) {
        super(source);
    }

    public ProductEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
