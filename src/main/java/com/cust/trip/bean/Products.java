package com.cust.trip.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author HUAWEI
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private int id;
    private String name;
    private int stock;
    private int quantity;
    private int sales;
    private double price;
    private String kind;
    private int status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp shelfTime;
    private Timestamp takedownTime;
}
