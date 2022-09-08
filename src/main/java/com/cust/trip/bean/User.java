package com.cust.trip.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
        private int id;
        private String name;
        private String password;
        private String phone;
        private double consumption;
        private double balance;
        private int vip;

}
