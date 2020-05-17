package com.itheima.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itheima.common.Result;

@RestController
@RequestMapping("/user")
public class UserLoginController {
    @GetMapping("/test")
    public Result test(){
        System.out.println("asdadad");
        return Result.ok();
    }
}
