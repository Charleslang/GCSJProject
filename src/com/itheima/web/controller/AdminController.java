package com.itheima.web.controller;

import com.itheima.web.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 管理员controller层
 *
 * @author Lv Bo
 * @create 2020-06-07
 * @version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping("admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    @ResponseBody
    public String getAdmin(String account){
        return adminService.getAdmin(account).getaPassword();
    }
}
