package com.itheima.web.service;

import com.itheima.web.entity.Admin;

/**
 * 管理员service层
 *
 * @author: Lv Bo
 * @create: 2020-06-07
 */
public interface AdminService {

    Admin getAdmin(String account);
}
