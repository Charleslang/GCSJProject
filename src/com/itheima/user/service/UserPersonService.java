package com.itheima.user.service;

import com.itheima.user.dto.LoginOrdinaryDTO;
import com.itheima.user.dto.LoginQQDTO;
import com.itheima.user.dto.RegisterDTO;
import com.itheima.user.dto.UpdateUserDTO;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface UserPersonService {

    /**
     * 功能描述: 更新用户信息
     * @param updateUserDTO 更新用户信息时相关参数
     * @return java.lang.Integer
     */
    Integer updateUserInfo(UpdateUserDTO updateUserDTO) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;
}
