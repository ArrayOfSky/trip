package com.cust.trip.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author GYF
 * @Data 2022.9.13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "管理员", description = "不要操作")
public class Manager implements Serializable {

    @ApiModelProperty("管理员id")
    private int managerId;

    @ApiModelProperty("管理员账号")
    private String managerAccount;

    @ApiModelProperty("管理员密码")
    private String managerPassword;

}
