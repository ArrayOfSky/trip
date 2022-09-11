package com.cust.trip.service;

import com.cust.trip.bean.Kind;
import com.cust.trip.bean.User;
import com.cust.trip.service.impl.KindServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GYF
 * @Data 2022.9.9
 */

public interface KindService {

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
     * 分页查询所有类型
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Kind> selectAllKind(int pageNum,int pageSize);

    /**
     * 根据姓名查询类型 建议用来获取id
     * @param name
     * @return 类型
     */
    Kind selectKindByName(String name);

    /**
     *  更新类型 将kind name为name1 更新 为 name 为 name2
     * @param name1
     * @param name2
     * @return 0 失败 1 成功 （后续修改）
     */
    int updateKind(String name1,String name2);


}
