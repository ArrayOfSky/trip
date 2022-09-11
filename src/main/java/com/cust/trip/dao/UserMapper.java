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
     * @param userName 用户名
     * @return 用户列表
     */
    List<User> selectUsersByName(String userName);

    /**
     * 通过电话号码获取用户
     *
     * @param userPhoneNumber 电话号码
     * @return 用户列表
     */
    User selectUserByPhoneNumber(String userPhoneNumber);


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
     * @param newUserPassword 新密码
     * @return 影响行数
     */
    int updatePassword(int id, String newUserPassword);

    /**
     * 修改用户名
     *
     * @param userId      用户id
     * @param newUserName 新的用户名
     * @return 影响的行数
     */
    int updateName(int userId, String newUserName);

    /**
     * 修改绑定的手机号
     *
     * @param userId       用户id
     * @param newUserPhoneNumber 新手机号
     * @return 影响的行数
     */
    int updatePhoneNumber(int userId, String newUserPhoneNumber);


    /**
     * 用户充值余额
     *
     * @param userId       用户id
     * @param inUserBalance 增加的余额
     * @return 影响的行数
     */
    int rechargeBalance(int userId, double inUserBalance);


    /**
     * 用户使用余额
     *
     * @param userId        用户id
     * @param deUserBalance 用户使用的余额
     * @return 影响的行数
     */
    int useBalance(int userId, double deUserBalance);

    /**
     * 用户进行消费
     *
     * @param userId          用户id
     * @param userConsumption 用户消费金额
     * @return 影响的行数
     */
    int consumption(int userId, double userConsumption);

    /**
     * 用户取消订单需要减少消费累计
     *
     * @param userId          用户id
     * @param userConsumption 回退的消费值
     * @return 影响的行数
     */
    int deConsumption(int userId, double userConsumption);

    /**
     * 更新用户vip等级
     *
     * @param userId  用户id
     * @param userVip 新的vip等级
     * @return 影响的行数
     */
    int updateVip(int userId, int userVip);
}
