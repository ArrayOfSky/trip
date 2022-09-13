package com.cust.trip.dao;

import com.cust.trip.bean.Manager;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.13
 */
@Mapper
public interface ManagerMapper {

    /**
     * 查找管理员
     * @param managerAccount
     * @return 管理员
     */
    Manager selectManagerByAccount(@Param("managerAccount") String managerAccount);

}
