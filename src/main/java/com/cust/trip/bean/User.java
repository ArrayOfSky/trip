package com.cust.trip.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @ApiModelProperty("用户id,数据库生成")
    private int userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户密码")
    private String userPassword;

    @ApiModelProperty("用户手机号")
    private String userPhoneNumber;

    @ApiModelProperty("用户消费值")
    private double userConsumption;

    @ApiModelProperty("用户余额")
    private double userBalance;

    @ApiModelProperty("用户vip等级")
    private int userVip;

    @ApiModelProperty("用户注册时间")
    private Timestamp userCreateTime;

}
