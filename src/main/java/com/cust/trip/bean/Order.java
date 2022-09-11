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
    private int orderId;
    private int orderProductId;
    private int orderUserId;
    private Timestamp orderCreateTime;
    private Timestamp orderUpdateTime;
    private int orderStatus;
    private double orderDiscount;
}
