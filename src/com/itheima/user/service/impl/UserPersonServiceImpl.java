package com.itheima.user.service.impl;

import com.itheima.common.RRException;
import com.itheima.common.redis.JedisUtil;
import com.itheima.common.utils.CommonUtils;
import com.itheima.common.utils.PBKDF2Util;
import com.itheima.entity.TbUser;
import com.itheima.entity.TbUserQq;
import com.itheima.user.dao.UserLoginDao;
import com.itheima.user.dao.UserPersonDao;
import com.itheima.user.dto.LoginOrdinaryDTO;
import com.itheima.user.dto.LoginQQDTO;
import com.itheima.user.dto.RegisterDTO;
import com.itheima.user.dto.UpdateUserDTO;
import com.itheima.user.pojo.User;
import com.itheima.user.pojo.UserOrdinary;
import com.itheima.user.pojo.UserQQ;
import com.itheima.user.service.UserLoginService;
import com.itheima.user.service.UserPersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Date;

import static com.itheima.util.StaticParams.*;

@Service
public class UserPersonServiceImpl implements UserPersonService {
    @Resource
    private UserPersonDao userPersonDao;
    @Resource
    private JedisUtil jedisUtil;


    @Override
    public Integer updateUserInfo(UpdateUserDTO updateUserDTO) throws NoSuchAlgorithmException, InvalidKeySpecException {

        User user = CommonUtils.getCurrentUser(jedisUtil);
        System.out.println(user);
        System.out.println(updateUserDTO.getPassword());
        if (user instanceof UserOrdinary) {
            //普通用户
            //用户id
            UserOrdinary userOrdinary = (UserOrdinary) user;
            TbUser tbUser = new TbUser();
            tbUser.setUId(userOrdinary.getmUserId());
            tbUser.setUNickname(updateUserDTO.getNickname());
            tbUser.setUGender(updateUserDTO.getGender());
            if(updateUserDTO.getProfile()!=null && !"".equals(updateUserDTO.getProfile())){
                tbUser.setUProfile(updateUserDTO.getProfile());
            }
            if (updateUserDTO.getPassword() != null && !"".equals(updateUserDTO.getPassword())) {
                tbUser.setUSalt(PBKDF2Util.generateSalt());
                tbUser.setUPassword(PBKDF2Util.getEncryptedPassword(updateUserDTO.getPassword(), tbUser.getUSalt()));
            }
            userOrdinary.setmNickname(tbUser.getUNickname());
            userOrdinary.setmGender(tbUser.getUGender());
            userOrdinary.setmProfile(tbUser.getUProfile());
            jedisUtil.putObjectWithExpire(userOrdinary.getmToken(), userOrdinary, TOKEN_VALIDITY);
            userPersonDao.updateUserInfoById(tbUser);
        } else {
            throw new RRException("QQ登陆，无法修改信息", 500);
        }
        return 1;
    }
}
