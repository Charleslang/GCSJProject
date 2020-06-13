package com.itheima.web.service.impl;

import com.itheima.web.dao.WebCommentsDao;
import com.itheima.web.dto.sreachcommentdto;
import com.itheima.web.entity.WebTbComments;
import com.itheima.web.entity.WebTbUsers;
import com.itheima.web.pojo.sreachcommentspojo;
import com.itheima.web.service.WebCommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author ChenKai
 * @Date 2020/6/8/008 20:49
 * @Version 1.0
 */
@Service
public class WebCommentsServiceimpl implements WebCommentsService {
    @Resource
    WebCommentsDao webCommentsDao;
    @Override
    public List<WebTbComments> getallcomments() {
      List<WebTbComments> list= webCommentsDao.getallcomments();
        for (WebTbComments comment : list) {
            if (comment.getcUsername().equals("")) {

                comment.setcUsername("用户已注销");
            }
        }
        return list;
    }

    @Override
    public void deletecommentbyid(Integer c_id) {
        webCommentsDao.deletecommentbyid(c_id);

    }

    @Override
    public Integer deltecomments(String[] ids) {
        Integer[] idlist=new Integer[ids.length];
        for (int i = 0; i < ids.length; i++) {
            idlist[i] = Integer.parseInt(ids[i]);
        }
        return webCommentsDao.deletecomments(idlist);
    }

    @Override
    public List<WebTbComments> sreachcomments(sreachcommentdto s) throws ParseException {
        if(s.getStart().equals(""))
        {
            s.setStart("2020-5-20");
        }
        if(s.getEnd().equals(""))
        {
            Date d = new Date();
            System.out.println(d);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String nowdate = sdf.format(d);
            s.setEnd(nowdate);
        }
        sreachcommentspojo sp=new sreachcommentspojo();
        sp.setStart(java.sql.Date.valueOf(s.getStart()));
        sp.setEnd(java.sql.Date.valueOf(s.getEnd()));
        sp.setUname(s.getUname());
        List<WebTbComments> list = webCommentsDao.sreachcomments(sp);
        return list;
    }

}
