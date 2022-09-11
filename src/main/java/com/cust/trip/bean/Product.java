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
    private int productId;
    private String productName;
    private int productStock;
    private int productQuantity;
    private int productSales;
    private double productPrice;
    private String kindName;
    private String statusName;
    private Timestamp productCreateTime;
    private Timestamp productUpdateTime;
    private Timestamp productShlfTime;
    private Timestamp productTakedownTime;
}
