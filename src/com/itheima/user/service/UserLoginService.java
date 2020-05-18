package com.itheima.user.service;

import com.itheima.user.dto.LoginQQDTO;
import com.itheima.user.pojo.User;
import com.itheima.user.pojo.UserQQ;

public interface UserLoginService {
    /**
     * 功能描述: qq登陆，返回用户信息
     * @param loginQQDTO 保存鉴权token和openid
     * @return com.itheima.user.pojo.User
     */
    UserQQ selectUserWhenLoginQQ(LoginQQDTO loginQQDTO);
    
}
