package com.itheima.user.dao;

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
}
