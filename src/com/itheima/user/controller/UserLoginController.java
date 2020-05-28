package com.itheima.user.controller;

import com.itheima.common.RRException;
import com.itheima.common.redis.JedisUtil;
import com.itheima.common.validator.AopValidator;
import com.itheima.user.dto.LoginQQDTO;
import com.itheima.user.dto.RegisterDTO;
import com.itheima.user.dto.t;
import com.itheima.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.itheima.common.Result;
import com.itheima.common.validator.DTOValidatorAnnotation;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private JedisUtil jedisUtil;
//    @GetMapping("/test")
//    public Result test(){
//        System.out.println("asdadad");
//        jedisUtil.putObjectWithExpire("test", "test", 60);
//        System.out.println(jedisUtil.getObject("test"));
//        return Result.ok(jedisUtil.getObject("test"));
//    }
    @PostMapping("/loginQQ")
    @DTOValidatorAnnotation
    public Result loginQQ(@RequestBody LoginQQDTO loginQQDTO){
        return Result.ok(userLoginService.selectUserWhenLoginQQ(loginQQDTO));
    }

    @PostMapping("/register")
    @DTOValidatorAnnotation
    public Result register(@RequestBody RegisterDTO registerDTO) throws InvalidKeySpecException, NoSuchAlgorithmException {
        userLoginService.registerUser(registerDTO);
        return Result.ok();
    }

    @GetMapping("/test")
    @DTOValidatorAnnotation
    public Result test(t tt){
//        throw new RRException("asdasd", 500);
        return null;
//        return Result.ok(userLoginService.test());
    }
}
