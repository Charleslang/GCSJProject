package com.itheima.web.controller;

import com.itheima.web.service.AdminService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 管理员controller层
 *
 * @author: Lv Bo
 * @create: 2020-06-07
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
