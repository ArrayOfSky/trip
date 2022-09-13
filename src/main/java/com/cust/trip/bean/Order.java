package com.cust.trip.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "订单")
public class Order {
    @ApiModelProperty("订单id，数据库生成")
    private int orderId;

    @ApiModelProperty("产品名称")
    private String orderProductName;

    @ApiModelProperty("用户名")
    private String orderUserName;

    @ApiModelProperty("订单创建时间")
    private Timestamp orderCreateTime;

    @ApiModelProperty("订单更新时间")
    private Timestamp orderUpdateTime;

    @ApiModelProperty("订单状态名称")
    private String orderStatusName;

    @ApiModelProperty("订单折扣")
    private double orderDiscount;

}
