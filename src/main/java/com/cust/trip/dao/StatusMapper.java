package com.cust.trip.dao;

import com.cust.trip.bean.Status;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.11
 */
@Mapper
public interface StatusMapper {

        /**
         * 查找所有状态
         * @return
         */
        List<Status> selectAllStatus();

        /**
         * 根据描述查找状态
         * @param description
         * @return
         */
        Status selectStatusByDescription(@Param("description") String description);

        /**
         * 增加状态
         * @param status
         */
        void insertStatus(@Param("status") Status status);

        /**
         * 删除状态
         * @param description
         */
        void deleteStatus(@Param("description") String description);

}
