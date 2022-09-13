package com.cust.trip.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author GYF
 * @Data 2022.9.11
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "状态")
public class Status {

    @ApiModelProperty("状态ID 数据库生成")
    private int statusId;

    @ApiModelProperty("状态类型")
    private String statusCategory;

    @ApiModelProperty("状态名称")
    private String statusName;
}
