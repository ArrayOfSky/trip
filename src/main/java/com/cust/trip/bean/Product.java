package com.cust.trip.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("产品")
public class Product {
    @ApiModelProperty("产品ID 数据库生成")
    private int productId;
    @ApiModelProperty("产品名称")
    private String productName;
    @ApiModelProperty("产品库存")
    private int productStock;
    @ApiModelProperty("产品数量 初始")
    private int productQuantity;
    @ApiModelProperty("产品销量")
    private int productSales;
    @ApiModelProperty("产品价格")
    private double productPrice;
    @ApiModelProperty("产品类型名称")
    private String kindName;
    @ApiModelProperty("产品状态名称")
    private String statusName;
    @ApiModelProperty("产品创造时间")
    private Timestamp productCreateTime;
    @ApiModelProperty("产品更新时间")
    private Timestamp productUpdateTime;
    @ApiModelProperty("上架时间")
    private Timestamp productShlfTime;
    @ApiModelProperty("下架时间")
    private Timestamp productTakedownTime;
}
