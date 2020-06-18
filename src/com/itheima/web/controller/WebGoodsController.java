package com.itheima.web.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.common.validator.DTOValidatorAnnotation;
import com.itheima.web.dto.GoodsDto;
import com.itheima.web.entity.WebTbGoods;
import com.itheima.web.service.WebGoodsService;
import com.itheima.web.service.impl.WebGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 商品管理controller层
 *
 * @author: Lv Bo
 * @create: 2020-06-05
 **/
@CrossOrigin
@RestController
@RequestMapping("/webGoods")
public class WebGoodsController {
    @Resource
    private WebGoodsService webGoodsService;

    @RequestMapping(value="/getAllGoods",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<WebTbGoods> getAllGoods(){
        return (ArrayList<WebTbGoods>) webGoodsService.getAllGoods();
    }

    @RequestMapping(value="/upload",method=RequestMethod.POST,produces="application/json;charset=utf-8")
    @ResponseBody//json交互注解
    public Map<String, Object> uploadResource(HttpServletRequest request, HttpServletResponse response, HttpSession session, MultipartFile file) throws Exception{
        String path = "D:/Java/Idea/GCSJProject/web/images";
        String fileName = file.getOriginalFilename();
        System.out.println(path+" "+fileName);
        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        //file.getInputStream().close();
        //upload要求返回的数据格式
        Map<String, Object> uploadData = new HashMap<String, Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        uploadData.put("code", "0");
        uploadData.put("msg", "");
        //将文件路径返回dir.getPath()
        data.put("src", dir.getPath());
        uploadData.put("data", data);
        //uploadData.put("data", "{\'src\':\'"+dir.getPath()+"\'}");
        return uploadData;
        /* 返回接口格式
	          "code": 0
	          ,"msg": ""
	          ,"data": {
	           "src": "http://cdn.layui.com/123.jpg"
	          }
	    */
    }

    @RequestMapping(value = "/addGoods",method = RequestMethod.POST)
    @ResponseBody
    public int addGoods(WebTbGoods webTbGoods){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前系统时间
        webTbGoods.setgAddTime(df.format(new Date()));
        return webGoodsService.addGoods(webTbGoods);
    }

    @RequestMapping(value = "/getGoods",method = RequestMethod.GET)
    @ResponseBody
    public WebTbGoods getGoods(String gId){
        return webGoodsService.getGoods(gId);
    }

    @RequestMapping(value = "/updateGoods",method = RequestMethod.POST)
    @ResponseBody
    public int updateGoods(GoodsDto goodsDto){
        return webGoodsService.updateGoods(goodsDto);
    }

    @RequestMapping(value = "/delGoods",method = RequestMethod.POST)
    @ResponseBody
    public int deleteGoods(int gId){
        return webGoodsService.deleteGoods(gId);
    }

    @RequestMapping(value = "/delAllGoods",method = RequestMethod.POST)
    @ResponseBody
    public int deleteAllGoods(String[] ids){
        for(int i=0;i<ids.length;i++){
            webGoodsService.deleteGoods(Integer.parseInt(ids[i]));
        }
        return 1;
    }

    @RequestMapping(value = "/getTypeGoods",method = RequestMethod.GET)
    @ResponseBody
    public List<WebTbGoods> getTypeGoods(Integer g_type){
        return webGoodsService.getTypeGoods(g_type);
    }

    @RequestMapping(value = "/getNameGoods",method = RequestMethod.GET)
    @ResponseBody
    public List<WebTbGoods> getNameGoods(String g_name){
        return webGoodsService.getNameGoods(g_name);
    }

    @RequestMapping(value = "/getDateGoods",method = RequestMethod.GET)
    public List<WebTbGoods> getDateGoods(String start,String end){
        return webGoodsService.getDateGoods(start,end);
    }

    @RequestMapping(value = "/getDateTypeGoods",method = RequestMethod.GET)
    public List<WebTbGoods> getDateTypeGoods(String start,String end,Integer g_type){
        return webGoodsService.getDateTypeGoods(start,end,g_type);
    }
}
