package com.cust.trip.service.impl;

import com.cust.trip.bean.Kind;

import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */
public interface KindServiceImpl {

    /**
     * 添加类型
     * @param kind
     * @return 0 失败 1 成功 （后续修改）
     */
    int addKind(Kind kind);

    /**
     * 根据姓名删除类型
     * @param name
     * @return 0 失败 1 成功 （后续修改）
     */
    int deleteKind(String name);

    /**
     * 查询所有类型
     * @return 类型清单
     */
    List<Kind> selectAllKind();

    /**
     * 根据姓名查询类型
     * @param name
     * @return 类型
     */
    Kind selectKindByName(String name);

    /**
     *  更新类型
     * @param name1
     * @param name2
     * @return 0 失败 1 成功 （后续修改）
     */
    int updateKind(String name1,String name2);

}
