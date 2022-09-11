package com.cust.trip;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

public class TimeTest {
    @Test
    public void testTime(){
        Date date = new Date();
        System.out.println(date);
        Timestamp time = new Timestamp(date.getTime());
        System.out.println(time);
    }
}
