package com.itheima.web.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itheima.web.dto.sreachorderdetaildto;
import com.itheima.web.entity.WebTbOrderDetail;
import com.itheima.web.service.impl.WebOrderDetailServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/ordtmanager")
public class WebOrderDetailController {
    @Resource
    WebOrderDetailServiceImpl webOrderDetailService;
    @RequestMapping(value="/getallorder",method = RequestMethod.GET)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public List<WebTbOrderDetail> getallorder()
    {
        List<WebTbOrderDetail> list = webOrderDetailService.getallorder();
        return list;
    }

    @RequestMapping(value="/deletbyid/{c_id}",method = RequestMethod.POST)
    public void deletbyid(@PathVariable(name = "c_id") String c_id)
    {
        System.out.println("id="+c_id);
        int id=Integer.parseInt(c_id);
        webOrderDetailService.deletbyid(id);
    }

    @RequestMapping(value="/deleteall",method = RequestMethod.POST)
    public Integer deleteall(@RequestBody String[] ids)
    {
        return webOrderDetailService.deleteall(ids);
    }

    @RequestMapping(value="/sreachorder",method = RequestMethod.POST)
    public List<WebTbOrderDetail> sreachorder(@RequestBody sreachorderdetaildto s) throws ParseException {
        System.out.println(s.toString());
        List<WebTbOrderDetail> list = webOrderDetailService.sreachorder(s);
        return list;
    }
}
