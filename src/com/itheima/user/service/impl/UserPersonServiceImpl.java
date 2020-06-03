package com.itheima.user.service.impl;

import com.itheima.common.RRException;
import com.itheima.common.redis.JedisUtil;
import com.itheima.common.utils.CommonUtils;
import com.itheima.common.utils.PBKDF2Util;
import com.itheima.entity.TbAddress;
import com.itheima.entity.TbUser;
import com.itheima.entity.TbUserQq;
import com.itheima.user.dao.UserLoginDao;
import com.itheima.user.dao.UserPersonDao;
import com.itheima.user.dto.*;
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
import java.util.List;

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
            if (updateUserDTO.getProfile() != null && !"".equals(updateUserDTO.getProfile())) {
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

    @Override
    public List<TbAddress> selectAddressList(AddressDTO addressDTO) {
        addressDTO.setPageNum(addressDTO.getPageSize() * (addressDTO.getPageNum() - 1));
        //设置用户id和用户类型
        User user = CommonUtils.getCurrentUser(jedisUtil);
        System.out.println(user);
        System.out.println(user instanceof UserOrdinary);
        if (user instanceof UserOrdinary) {
            addressDTO.setUserId(((UserOrdinary) user).getmUserId() + "");
        } else {
            addressDTO.setUserId(((UserQQ) user).getmOpenid());
        }
        List<List<?>> sqlRes = userPersonDao.selectAddressList(addressDTO);
        return (List<TbAddress>) sqlRes.get(0);
    }

    @Override
    public void updateAddress(UpdateAddressDTO updateAddressDTO) {
        userPersonDao.updateAddress(updateAddressDTO);
    }

    @Override
    public void insertAddress(InsertAddressDTO insertAddressDTO) {
        TbAddress tbAddress = new TbAddress();
        tbAddress.setaDetails(insertAddressDTO.getDetails());
        tbAddress.setaUniversity(insertAddressDTO.getUniversity());

        tbAddress.setaCreateTime(new Date(System.currentTimeMillis()));
        tbAddress.setaUserDefault(0);
        User user = CommonUtils.getCurrentUser(jedisUtil);
        if (user instanceof UserOrdinary) {
            tbAddress.setaUserId(((UserOrdinary) user).getmUserId() + "");
        } else if (user instanceof UserQQ) {
            tbAddress.setaUserId(((UserQQ) user).getmOpenid());
        }
        userPersonDao.insertAddress(tbAddress);
    }

    @Override
    public void updateUserDefault(Integer addressId) {
        String userId = null;
        User user = CommonUtils.getCurrentUser(jedisUtil);
        if (user instanceof UserOrdinary) {
            userId = ((UserOrdinary) user).getmUserId() + "";
        } else if (user instanceof UserQQ) {
            userId = ((UserQQ) user).getmOpenid();
        }
        userPersonDao.updateUserDefault(userId, addressId);
    }

    @Override
    public void deleteAddress(Integer addressId) {
        userPersonDao.deleteAddress(addressId);
    }
}
