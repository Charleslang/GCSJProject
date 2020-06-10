package com.itheima.web.service.impl;

import com.itheima.web.dao.AdminDao;
import com.itheima.web.entity.Admin;
import com.itheima.web.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    AdminDao adminDao;

    @Override
    public Admin getAdmin(String account) {
        return adminDao.getAdmin(account);
    }
}
