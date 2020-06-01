package com.itheima.user.controller;

import com.itheima.common.Result;
import com.itheima.common.redis.JedisUtil;
import com.itheima.common.utils.CommonUtils;
import com.itheima.common.validator.DTOValidatorAnnotation;
import com.itheima.user.dto.UpdateUserDTO;
import com.itheima.user.pojo.User;
import com.itheima.user.pojo.UserOrdinary;
import com.itheima.user.service.UserPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

/**
 * 用户个人管理接口
 *
 * @author: qinjie
 **/
@RestController
@RequestMapping("/users")
public class UserPersonInfoController {

    @Resource
    private JedisUtil jedisUtil;

    @Autowired
    private UserPersonService userPersonService;

    //获取用户信息普通
    @GetMapping("/info")
    Result selectPersonalInfo() {
        User user = CommonUtils.getCurrentUser(jedisUtil);
        HashMap res = new HashMap();
        System.out.println(user instanceof UserOrdinary);
        System.out.println(user);
        System.out.println((UserOrdinary)user);
        if (user instanceof UserOrdinary) {
            //标识普通用户
            res.put("userType", 1);
        } else {
            //标识qq用户
            res.put("userType", 2);
        }
        res.put("userInfo", user);
        return Result.ok(res);
    }
    //更新用户信息
    @PostMapping("/info/update")
    @DTOValidatorAnnotation
    Result updateUserInfo(@RequestBody UpdateUserDTO updateUserDTO) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {

        userPersonService.updateUserInfo(updateUserDTO);
        return Result.ok();
    }
}
