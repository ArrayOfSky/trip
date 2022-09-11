package com.cust.trip.dao;

import com.cust.trip.bean.Kind;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */
@Mapper
public interface KindMapper {
    /**
     * 查询所有种类
     * @return 类型列表
     */
    List<Kind> selectAll();

    /**
     * 增加种类
     * @param kind 种类
     */
    void insertKind(@Param("kind") Kind kind);

    /**
     * 根据种类名删除种类
     * @param name 种类名
     */
    void deleteKind(@Param("kindName") String kindName);

    /**
     *  更新种类数据
     * @param kind
     */
    void updateKind(@Param("kind") Kind kind);
}
