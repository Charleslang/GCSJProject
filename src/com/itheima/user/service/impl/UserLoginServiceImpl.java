package com.itheima.user.service.impl;

import com.itheima.common.redis.JedisUtil;
import com.itheima.common.utils.CommonUtils;
import com.itheima.user.dao.UserLoginDao;
import com.itheima.user.dto.LoginQQDTO;
import com.itheima.user.pojo.User;
import com.itheima.user.pojo.UserQQ;
import com.itheima.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    private UserLoginDao userLoginDao;
    @Resource
    private JedisUtil jedisUtil;
    @Override
    public UserQQ selectUserWhenLoginQQ(LoginQQDTO loginDTO) {
        //通过openid查询数据库是否存在用户
        UserQQ userQQ = userLoginDao.selectUserQq(loginDTO.getOpenid());
        if(userQQ!=null){
            //数据库存在qq用户
            //直接返回用户信息，更新登陆次数
            userLoginDao.updateUserQqLoginTime();
            //生成平台token
            String token = System.currentTimeMillis()+""+CommonUtils.getRandomString(10);
            jedisUtil.putObjectWithExpire(token, userQQ, 60);
        }else{

        }

        return userQQ;
    }
}
