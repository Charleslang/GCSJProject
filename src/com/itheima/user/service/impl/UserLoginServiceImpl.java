package com.itheima.user.service.impl;

import com.itheima.common.RRException;
import com.itheima.common.redis.JedisUtil;
import com.itheima.common.utils.CommonUtils;
import com.itheima.entity.TbUser;
import com.itheima.entity.TbUserQq;
import com.itheima.user.dao.UserLoginDao;
import com.itheima.user.dto.LoginQQDTO;
import com.itheima.user.pojo.UserQQ;
import com.itheima.user.service.UserLoginService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;

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
            userLoginDao.updateUserQqLoginTime(loginDTO.getOpenid());
        }else{
            userQQ = new UserQQ();
            //数据库不存在，插入用户
            TbUserQq tbUserQq = new TbUserQq();
            tbUserQq.setUQCreateTime(new java.sql.Date(System.currentTimeMillis()));
            tbUserQq.setUQLoginTime(1);
            tbUserQq.setUQProfile(loginDTO.getProfile());
            tbUserQq.setUQNickname(loginDTO.getNickname());
            tbUserQq.setUQGender(loginDTO.getGender());
            tbUserQq.setUQOpenid(loginDTO.getOpenid());
            userLoginDao.insertUserQq(tbUserQq);

            //设置返回值
            userQQ.setmGender(loginDTO.getGender());
            userQQ.setmNickname(loginDTO.getNickname());
            userQQ.setmOpenid(loginDTO.getOpenid());
            userQQ.setmProfile(loginDTO.getProfile());
        }
//生成平台token
        String token = System.currentTimeMillis()+""+CommonUtils.getRandomString(7);
//        throw new RRException(token+""+userQQ.toString(), 200);
        jedisUtil.putObjectWithExpire(token, userQQ, 3600);
        userQQ.setmToken(token);
        return userQQ;
    }

    @Override
    @Transactional
    public Object test() {
        //测试事务的隔离级别

        //
        TbUser user = new TbUser();
        user.setUAccount("123456789");
        user.setUCreateTime(new Date(System.currentTimeMillis()));
        userLoginDao.insertUser(user);


        //读取用户
        System.out.println(userLoginDao.selectUserByAccount("123456789"));
        System.out.println(userLoginDao.selectUserByAccount("123456789").getUAccount());

        int a = 1/0;
        return null;
    }

    public static void main(String args[]){
    }
}
