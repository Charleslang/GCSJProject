package com.itheima.web.dao;

import com.itheima.web.entity.Admin;

/**
 * 管理员dao层
 *
 * @author: Lv Bo
 * @create: 2020-06-07
 **/
public interface AdminDao {

    Admin getAdmin(String account);
}
