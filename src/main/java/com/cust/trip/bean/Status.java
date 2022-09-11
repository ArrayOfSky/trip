package com.cust.trip.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GYF
 * @Data 2022.9.11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    private int statusId;
    private String statusKind;
    private String statusDescription;
}
