package com.cust.trip.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author guoyixing
 * 2022/9/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private int productId;
    private int userId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int status;
    private double discount;
}
