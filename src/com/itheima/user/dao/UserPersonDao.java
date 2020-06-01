package com.itheima.user.dao;

import com.itheima.entity.TbUser;
import com.itheima.entity.TbUserQq;
import com.itheima.user.pojo.UserQQ;

public interface UserPersonDao {
    //更新用户信息
    Integer updateUserInfoById(TbUser tbUser);
}
