package com.itheima.web.service;

import com.itheima.web.dto.sreachcommentdto;
import com.itheima.web.entity.WebTbComments;
import com.itheima.web.entity.WebTbUsers;

import java.text.ParseException;
import java.util.List;

/**
 * @Author ChenKai
 * @Date 2020/6/8/008 17:11
 * @Version 1.0
 */
public interface WebCommentsService {
    //获得所有的用户
    List<WebTbComments> getallcomments();
    //通过id删除评论
    void deletecommentbyid(Integer c_id);
    //批量删除评论
    Integer deltecomments(String[] ids);
    //根据条件查找评论
    List<WebTbComments> sreachcomments(sreachcommentdto s) throws ParseException;
}
