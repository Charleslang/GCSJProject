package com.itheima.web.dao;

import com.itheima.web.entity.WebTbNotice;
import com.itheima.web.pojo.notice;
import com.itheima.web.pojo.sreachnoticepojo;

import java.util.List;

public interface WebNoticeDao {
    //得到所有的评论
    List<WebTbNotice> getallnotice();
    //根据id删除评论
    void deletbyid(Integer c_id);
    //根据id批量删除评论
    Integer deleteall(Integer[] ids);
    //根据条件查询评论
    List<WebTbNotice> sreachnotice(sreachnoticepojo sreachnoticepojo);
    //添加
    int addNotice(notice notice);
}
