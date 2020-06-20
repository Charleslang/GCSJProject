package com.itheima.web.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itheima.web.dto.sreachcommentdto;
import com.itheima.web.entity.WebTbComments;
import com.itheima.web.service.WebCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @Author ChenKai
 * @Date 2020/6/8/008 20:52
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/comments_manage")
public class WebCommentsController {
    @Autowired
    WebCommentsService webCommentsService;
    @RequestMapping("/getallcomments")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public List<WebTbComments> getallcomments(){
        List<WebTbComments> list=webCommentsService.getallcomments();
        return list;
    }
    @RequestMapping("/deletecommentbyid/{c_id}")
    public void deletcommentbyid(@PathVariable(name = "c_id") String c_id)
    {
        System.out.println("id="+c_id);
        int id=Integer.parseInt(c_id);
        webCommentsService.deletecommentbyid(id);
    }
    @RequestMapping("/deletecomments")
    public Integer deletecomments(@RequestBody String[] ids)
    {
        return webCommentsService.deltecomments(ids);
    }
    @RequestMapping("/sreachcomments")
    public  List<WebTbComments> sreachcomments(@RequestBody sreachcommentdto s) throws ParseException {
        System.out.println(s.toString());
        List<WebTbComments> list=webCommentsService.sreachcomments(s);
        return list;
    }

}
