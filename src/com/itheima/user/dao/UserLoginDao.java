package com.itheima.user.dao;

import com.itheima.entity.TbUser;
import com.itheima.entity.TbUserQq;
import com.itheima.user.pojo.User;
import com.itheima.user.pojo.UserQQ;

public interface UserLoginDao {
    //插入qq用户
    Integer insertUserQq(TbUserQq tbUserQq);
    //更新qq登陆次数
    Integer updateUserQqLoginTime(String openid);
    //查询是否存在用户
    UserQQ selectUserQq(String openid);
    //新增普通用户
    Integer insertUser(TbUser tbUser);
    //查询普通用户通过账户
    TbUser selectUserByAccount(String account);
    //查询普通用户通过邮箱
    TbUser selectUserByEmail(String email);
    //更新用户
    Integer updateUserByUserId(Integer userId);
}
