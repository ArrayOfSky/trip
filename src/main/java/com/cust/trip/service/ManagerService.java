package com.cust.trip.service;

import com.cust.trip.bean.Manager;

/**
 * @author GYF
 * @Data 2022.9.12
 */
public interface ManagerService {

    /**
     * 登陆
     * @param manager
     * @return 0失败 1成功
     */
     int login(Manager manager);

}
