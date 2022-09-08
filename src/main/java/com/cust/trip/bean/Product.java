package com.cust.trip.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private int stock;
    private int quantity;
    private int sales;
    private double price;
    private int kind;
    private int status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp shelfTime;
    private Timestamp takedownTime;
}
