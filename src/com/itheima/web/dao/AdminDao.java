package com.itheima.web.dao;

import com.itheima.web.entity.Admin;

/**
 * 管理员dao层
 *
 * @author Lv Bo
 * @create 2020-06-07
 * @version 1.0
 **/
public interface AdminDao {
    /**
     *该方法根据账户查找管理员信息
     * @param account 管理员账户
     * @return ResultSet结果集，若查询失败则返回null
     */
    Admin getAdmin(String account);
}
