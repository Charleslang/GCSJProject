package com.itheima.web.service;

import com.itheima.web.dto.newUser;
import com.itheima.web.dto.newpass;
import com.itheima.web.entity.WebTbUsers;
import com.itheima.web.pojo.user;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * @Author ChenKai
 * @Date 2020/6/5/005 21:40
 * @Version 1.0
 */
public interface WebUserService {
    //获得所有的用户
    List<WebTbUsers> getallusers();
    //根据用户id删除用户
    void deleteuserbyid(int u_id);
    //得到用户信息，并生成颜值，加密密码，返回pojo对象
    int  adduser(newUser newuser) throws NoSuchAlgorithmException, InvalidKeySpecException;
    //根据id批量删除用户
    int  deleteusers(String[] list);
    //修改密码
    int updatepass(newpass newpass) throws InvalidKeySpecException, NoSuchAlgorithmException;
}
