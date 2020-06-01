package com.itheima.user.service;

import com.itheima.user.dto.LoginOrdinaryDTO;
import com.itheima.user.dto.LoginQQDTO;
import com.itheima.user.dto.RegisterDTO;
import com.itheima.user.dto.UpdateUserDTO;
import com.itheima.user.pojo.User;
import com.itheima.user.pojo.UserQQ;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface UserLoginService {
    /**
     * 功能描述: qq登陆，返回用户信息
     * @param loginQQDTO 保存鉴权token和openid
     * @return String
     */
    String selectUserWhenLoginQQ(LoginQQDTO loginQQDTO);
    /**
     * 功能描述: 普通用户登陆
     * @param loginOrdinaryDTO 保存邮箱密码
     * @return java.lang.String
     */
    String selectUserWhenLoginOrdinary(LoginOrdinaryDTO loginOrdinaryDTO);
    /**
     * 功能描述: 注册普通用户
     * @param registerDTO 注册用户时相关参数
     * @return java.lang.Integer
     */
    Integer registerUser(RegisterDTO registerDTO) throws NoSuchAlgorithmException, InvalidKeySpecException;
    /**
     * 功能描述: 退出登陆，删除token
     * @return java.lang.Integer
     */
    Integer logout();
    Object test();
}
