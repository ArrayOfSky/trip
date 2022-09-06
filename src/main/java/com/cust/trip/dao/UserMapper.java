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
     * @return 用户列表
     */
    List<User> getAllUsers();

    /**
     * 通过用户名获取用户
     * @param name 用户名
     * @return 用户列表
     */
    List<User> getUsersByName(String name);

    /**
     * 通过电话号码获取用户
     * @param phoneNumber 电话号码
     * @return 用户列表
     */
    User       getUserByPhoneNumber(String phoneNumber);

    /**
     * 依据消费区间获取用户
     * @param consumption1 低消费
     * @param consumption2 高消费
     * @return 用户列表
     */
    List<User> getUsersByConsumptions(double consumption1,double consumption2);

    /**
     * 获取某值以下的消费人群
     * @param lowConsumption 低值
     * @return 用户列表
     */
    List<User> getUsersByLowConsumption(double lowConsumption);

    /**
     * 获取某值以上的消费人群
     * @param highConsumption 高值
     * @return 用户列表
     */
    List<User> getUsersByHighConsumption(double highConsumption);

    /**
     *获取某区间的消费人群
     * @param balance1 低余额
     * @param balance2 高余额
     * @return 用户列表
     */
    List<User> getUsersByBalances(double balance1,double balance2);

    /**
     * 获取某值以下的消费人群
     * @param lowBalance 低值
     * @return 用户列表
     */
    List<User> getUsersByLowBalance(double lowBalance);

    /**
     * 获取某值以上的消费人群
     * @param highBalance 高值
     * @return 用户列表
     */
    List<User> getUsersByHighBalance(double highBalance);

    /**
     * 获取某区间的消费人群
     * @param vip1 低等级
     * @param vip2 高等级
     * @return 用户列表
     */
    List<User> getUsersByVips(double vip1,double vip2);

    /**
     * 获取某值以上的消费人群
     * @param lowVip 低等级
     * @return 用户列表
     */
    List<User> getUsersByLowVip(double lowVip);

    /**
     * 获取某值以上的消费人群
     * @param highVip 高等级
     * @return 用户列表
     */
    List<User> getUsersByHighVip(double highVip);

}
