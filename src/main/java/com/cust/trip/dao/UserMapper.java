package com.cust.trip.dao;

import com.cust.trip.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author guoyixing
 * 2022/9/6
 */
@Mapper
public interface UserMapper {
    /**
     * 获取所有用户
     *
     * @return 用户列表
     */
    List<User> selectAllUsers();

    /**
     * 通过用户名获取用户
     *
     * @param name 用户名
     * @return 用户列表
     */
    List<User> selectUsersByName(String name);

    /**
     * 通过电话号码获取用户
     *
     * @param phoneNumber 电话号码
     * @return 用户列表
     */
    User selectUserByPhoneNumber(String phoneNumber);


    /**
     * 添加用户
     *
     * @param user 新添加的用户
     * @return 影响行数
     */
    int insertUser(User user);


    /**
     * 修改密码
     *
     * @param id          用户id
     * @param newPassword 新密码
     * @return 影响行数
     */
    int updatePassword(int id, String newPassword);

    /**
     * 修改用户名
     *
     * @param id      用户id
     * @param newName 新的用户名
     * @return 影响的行数
     */
    int updateName(int id, String newName);

    /**
     * 修改绑定的手机号
     *
     * @param id          用户id
     * @param phoneNumber 新手机号
     * @return 影响的行数
     */
    int updatePhoneNumber(int id, String phoneNumber);


    /**
     * 用户充值余额
     *
     * @param id        用户id
     * @param inBalance 增加的余额
     * @return 影响的行数
     */
    int rechargeBalance(int id, double inBalance);


    /**
     * 用户使用余额
     *
     * @param id        用户id
     * @param deBalance 用户使用的余额
     * @return 影响的行数
     */
    int useBalance(int id, double deBalance);

    /**
     * 用户进行消费
     *
     * @param id          用户id
     * @param consumption 用户消费金额
     * @return 影响的行数
     */
    int consumption(int id, double consumption);

    /**
     * 用户取消订单需要减少消费累计
     *
     * @param id          用户id
     * @param consumption 回退的消费值
     * @return 影响的行数
     */
    int deConsumption(int id, double consumption);

    /**
     * 更新用户vip等级
     *
     * @param id  用户id
     * @param vip 新的vip等级
     * @return 影响的行数
     */
    int updateVip(int id, int vip);
}
