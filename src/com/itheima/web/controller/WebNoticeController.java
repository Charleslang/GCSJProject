package com.itheima.web.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itheima.web.dto.newNotice;
import com.itheima.web.dto.sreachnoticedto;
import com.itheima.web.entity.WebTbNotice;
import com.itheima.web.service.impl.WebNoticeServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.List;
/**
 * @Author hyh
 */
@CrossOrigin
@RestController
@RequestMapping("/notmanager")
public class WebNoticeController {
    @Resource
    WebNoticeServiceImpl webNoticeService;
    @RequestMapping(value="/getallnotice",method = RequestMethod.GET)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public List<WebTbNotice> getallnotice(){
        System.out.println("getallnotice");
        List<WebTbNotice> list=webNoticeService.getallnotice();
        return list;
    }
    @RequestMapping(value="/deletbyid/{c_id}",method = RequestMethod.POST)
    public void deletbyid(@PathVariable(name = "c_id") String c_id)
    {
        System.out.println("id="+c_id);
        int id=Integer.parseInt(c_id);
        webNoticeService.deletbyid(id);
    }
    @RequestMapping(value="/deleteall",method = RequestMethod.POST)
    public Integer deleteall(@RequestBody String[] ids)
    {
        return webNoticeService.deleteall(ids);
    }

    @RequestMapping(value="/sreachnotice",method = RequestMethod.POST)
    public  List<WebTbNotice> sreachnotice(@RequestBody sreachnoticedto s) throws ParseException {
        System.out.println(s.toString());
        List<WebTbNotice> list=webNoticeService.sreachnotice(s);
        return list;
    }

    @RequestMapping(value="/addnotice",method = RequestMethod.POST)
    public int addNotice(@RequestBody newNotice n) throws NoSuchAlgorithmException, InvalidKeySpecException {
        System.out.println("sada");
        System.out.println("addnotice");
        System.out.println(n.toString());
       // System.out.println(n.getnTitle());
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前系统时间
        //System.out.println(df.format(new Date()));
        //webTbNotice.setnPubtime(df.format(new Date()));

        return webNoticeService.addNotice(n);

    }

}
