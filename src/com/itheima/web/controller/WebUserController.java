package com.itheima.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.web.dto.newUser;
import com.itheima.web.dto.newpass;
import com.itheima.web.entity.WebTbUsers;
import com.itheima.web.service.WebUserService;
import com.itheima.web.service.impl.WebUserServiceImpl;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.aspectj.weaver.SourceContextImpl;
import org.aspectj.weaver.patterns.ScopeWithTypeVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * @Author ChenKai
 * @Date 2020/6/5/005 21:39
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/UserManage")
public class WebUserController {
    @Autowired
    WebUserService webUserService;
    //发送所有的用户数据
    @RequestMapping("/getAllUser")
   public List<WebTbUsers> getAllUser(){
        System.out.println("getalluser执行了！！！！");
        System.out.println(webUserService.getallusers().get(0).toString());
        List<WebTbUsers> userlist=webUserService.getallusers();
        return userlist;
    }
   @RequestMapping("/deleteuserbyid/{u_id}")
    public void deleteuserbyid(@PathVariable(name = "u_id") String u_id){
       System.out.println(u_id);
       int id=Integer.parseInt(u_id);
       webUserService.deleteuserbyid(id);
   }
   @RequestMapping("/adduser")
    public Integer adduser(@RequestBody newUser user) throws InvalidKeySpecException, NoSuchAlgorithmException {
       System.out.println("adduser");
       System.out.println(user.toString());
       int flag=webUserService.adduser(user);
       System.out.println("flag="+flag);
      return flag;
   }
   @RequestMapping("/deleteusers")
   public Integer deleteusers(@RequestBody String[] idlist){
       return webUserService.deleteusers(idlist);

   }
    @RequestMapping("/editpass")
    public Integer editpass(@RequestBody newpass p) throws InvalidKeySpecException, NoSuchAlgorithmException {

        return  webUserService.updatepass(p);

    }


}
