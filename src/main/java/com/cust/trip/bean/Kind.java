package com.cust.trip.bean;

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
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "类型")
public class Kind {

        @ApiModelProperty("类型ID 数据库生成")
        private int kindId;

        @ApiModelProperty("类型名称")
        private String kindName;
}
