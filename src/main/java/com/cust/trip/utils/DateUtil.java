package com.cust.trip.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gyx
 * 2022/9/12
 */
@Slf4j
public class DateUtil {
    private static final SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");

    public static Date stringToDate(String dateString){
        Date date=null;
        try {
             date = sdf.parse(dateString);
        } catch (ParseException e) {
            log.error("字符转换日期出现错误");
            e.printStackTrace();
        }
        return date;
    }
}
