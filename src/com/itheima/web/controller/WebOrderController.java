package com.itheima.web.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itheima.web.dto.sreachorderdto;
import com.itheima.web.entity.WebTbOrder;
import com.itheima.web.service.impl.WebOrderServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ordmanager")
public class WebOrderController {
    @Resource
    WebOrderServiceImpl webOrderService;
    @RequestMapping(value="/getallorder",method = RequestMethod.GET)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public List<WebTbOrder> getallorder(){
        List<WebTbOrder> list = webOrderService.getallorder();
        return list;
    }

    @RequestMapping(value="/deletbyid/{c_id}",method = RequestMethod.POST)
    public void deletbyid(@PathVariable(name = "c_id") String c_id)
    {
        System.out.println("id="+c_id);
        int id=Integer.parseInt(c_id);
        webOrderService.deletbyid(id);
    }
    @RequestMapping(value="/deleteall",method = RequestMethod.POST)
    public Integer deleteall(@RequestBody String[] ids)
    {
        return webOrderService.deleteall(ids);
    }

    @RequestMapping(value="/sreachorder",method = RequestMethod.POST)
    public  List<WebTbOrder> sreachorder(@RequestBody sreachorderdto s) throws ParseException
    {
        System.out.println(s.toString());
        List<WebTbOrder> list=webOrderService.sreachorder(s);
        return list;
    }
}
