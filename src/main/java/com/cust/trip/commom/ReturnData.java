package com.cust.trip.commom;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("返回数据")
public class ReturnData {
    @ApiModelProperty("返回值")
    private Integer code;
    @ApiModelProperty("返回信息")
    private String msg;
    @ApiModelProperty("返回数据")
    private Object data;

    public ReturnData(Code code, String msg, Object data) {
    }

}
