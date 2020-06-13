package com.itheima.web.dao;

import com.itheima.web.entity.WebTbUsers;
import com.itheima.web.pojo.pass;
import com.itheima.web.pojo.user;
import com.itheima.web.pojo.usersreachpojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ChenKai
 * @Date 2020/6/5/005 21:20
 * @Version 1.0
 */
public interface WebUserDao {
    //获取所有的用户
    List<WebTbUsers> getalluser();
    //根据id删除用户
    void deleteuserbyid(int u_id);
    //添加用户
    int  adduser(user user);
    //根据邮箱查找用户
    String selectuserbyemail(String email);
    //根据id批量删除用户
    Integer deleteusers(Integer[] idlist);
    //根据id得到salt和pass
    pass getpassbyid(Integer id);
    //修改密码
    int updatepass(pass pass);
    //根据条件查找用户
    List<WebTbUsers> finduser(usersreachpojo u);

}
