package com.itheima.web.dao;

import com.itheima.web.dto.sreachcommentdto;
import com.itheima.web.entity.WebTbComments;
import com.itheima.web.pojo.sreachcommentspojo;

import java.util.List;

/**
 * @Author ChenKai
 * @Date 2020/6/8/008 17:06
 * @Version 1.0
 */
public interface WebCommentsDao {
    //得到所有的评论
    List<WebTbComments> getallcomments();
    //根据id删除评论
    void deletecommentbyid(Integer c_id);
    //根据id批量删除评论
    Integer deletecomments(Integer[] ids);
    //根据条件查询评论
    List<WebTbComments> sreachcomments(sreachcommentspojo sreachcommentspojo);


}
