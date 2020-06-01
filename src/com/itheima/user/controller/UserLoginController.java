package com.itheima.user.controller;

import com.itheima.common.RRException;
import com.itheima.common.redis.JedisUtil;
import com.itheima.common.utils.CommonUtils;
import com.itheima.common.validator.AopValidator;
import com.itheima.user.dto.LoginOrdinaryDTO;
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
@RequestMapping("/users")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private JedisUtil jedisUtil;
    @PostMapping("/loginQQ")
    @DTOValidatorAnnotation
    public Result loginQQ(@RequestBody LoginQQDTO loginQQDTO){
        return Result.ok(userLoginService.selectUserWhenLoginQQ(loginQQDTO));
    }
    @PostMapping("/login")
    @DTOValidatorAnnotation
    public Result login(@RequestBody LoginOrdinaryDTO loginOrdinaryDTO) {
        return Result.ok(userLoginService.selectUserWhenLoginOrdinary(loginOrdinaryDTO));
    }
    @GetMapping("/logout")
    public Result logout() {
//        jedisUtil.removeObject()
        return Result.ok();
    }

    @PostMapping("/register")
    @DTOValidatorAnnotation
    public Result register(@RequestBody RegisterDTO registerDTO) throws InvalidKeySpecException, NoSuchAlgorithmException {
        userLoginService.registerUser(registerDTO);
        return Result.ok();
    }
    @GetMapping("t")
    public void a(){
        jedisUtil.putObjectWithExpire("topke", "", 1000);
    }
}
