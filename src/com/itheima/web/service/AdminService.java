package com.itheima.web.service;

import com.itheima.web.entity.Admin;

/**
 * 管理员service层
 *
 * @author Lv Bo
 * @create 2020-06-07
 * @version 1.0
 */
public interface AdminService {
    /**
     *定义得到管理员信息的抽象方法
     */
    Admin getAdmin(String account);
}
