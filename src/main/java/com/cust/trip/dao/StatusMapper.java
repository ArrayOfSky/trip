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
         * @return 状态列表
         */
        List<Status> selectAllStatus();

        /**
         * 根据描述查找状态
         * @param statusName 状态名
         * @return 状态
         */
        Status selectStatusByName(@Param("statusName") String statusName);

        /**
         * 增加状态
         * @param status 状态
         */
        void insertStatus(@Param("status") Status status);

        /**
         * 删除状态
         * @param statusName 状态名
         */
        void deleteStatus(@Param("statusName") String statusName);

}
