package com.itheima.user.controller;

import com.itheima.common.redis.JedisUtil;
import com.itheima.common.validator.AopValidator;
import com.itheima.user.dto.LoginQQDTO;
import com.itheima.user.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.itheima.common.Result;
import com.itheima.common.validator.DTOValidatorAnnotation;

@RestController
@RequestMapping("/user")
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
    public Result register(@RequestBody LoginQQDTO loginQQDTO){
        return Result.ok(userLoginService.selectUserWhenLoginQQ(loginQQDTO));
    }

    @GetMapping("/test")
    public Result test(){
        return Result.ok(userLoginService.test());
    }
}
