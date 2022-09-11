package com.cust.trip.commom;

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
public class ReturnData {
    private Integer code;
    private String msg;
    private Object data;
}
