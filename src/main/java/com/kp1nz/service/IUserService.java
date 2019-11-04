package com.kp1nz.service;

import com.kp1nz.common.ServerResponse;
import com.kp1nz.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author kp1nz
 * @create 2019-01-04 18:42
 */
public interface IUserService {
    /**
     * 登录接口
     */
    ServerResponse login(String username,String password);
    /**
     * 注册接口
     */
    ServerResponse register(UserInfo userInfo);
    /**
     * 根据用户名查找密保问题
     */
    ServerResponse forget_get_question(String username);
    /**
     * 提交问题答案
     */
    ServerResponse forget_check_answer(String username,String question,String answer);
    /**
     * 忘记密码的重置密码
     */
    ServerResponse forget_reset_password(String username,String passwordNew,String forgetToken);
    /**
     * 检查用户名或者邮箱是否有效
     */
    ServerResponse check_valid(String str,String type);
    /**
     * 获取登录用户信息
     */
    ServerResponse reset_password(String username,String passwordOld,String passwordNew);
    /**
     * 登录状态更新个人信息
     */
    ServerResponse update_information(UserInfo user);
    /**
     * 通过userid查询用户信息
     */
    UserInfo findUserInfoByUserid(Integer userId);

    /**
     * 保存用户token信息
     */
    int updateTokenByUserid (Integer userId ,String token);

    /**
     * 根据token查询用户信息
     */
    UserInfo findUserInfoByToken(String token);
}
