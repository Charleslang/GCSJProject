package com.itheima.web.service;

import com.itheima.web.dto.newNotice;
import com.itheima.web.dto.sreachnoticedto;
import com.itheima.web.entity.WebTbNotice;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.List;
/**
 * @Author hyh
 */
public interface WebNoticeService {
    //获得所有的公告
    List<WebTbNotice> getallnotice();
    //通过id删除公告
    void deletbyid(Integer c_id);
    //批量删除公告
    Integer deleteall(String[] ids);
    //根据条件查找公告
    List<WebTbNotice> sreachnotice(sreachnoticedto s) throws ParseException;
    //添加公告
    int addNotice(newNotice newNotice)throws NoSuchAlgorithmException, InvalidKeySpecException;
}
