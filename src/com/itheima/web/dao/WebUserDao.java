package com.itheima.web.dao;

import com.itheima.web.entity.WebTbUsers;

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
}
