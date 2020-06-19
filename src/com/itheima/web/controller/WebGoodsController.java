package com.itheima.web.controller;

import com.itheima.web.dto.GoodsDto;
import com.itheima.web.entity.WebTbGoods;
import com.itheima.web.service.WebGoodsService;
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
 * @author Lv Bo
 * @create 2020-06-05
 * @version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping("/webGoods")
public class WebGoodsController {
    @Resource
    private WebGoodsService webGoodsService;

    /**
     * 得到所有商品信息
     */
    @RequestMapping(value="/getAllGoods",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<WebTbGoods> getAllGoods(){
        return (ArrayList<WebTbGoods>) webGoodsService.getAllGoods();
    }
    /**
     *该方法上次图片到服务器
     * @param request HttpServletRequest对象
     * @param response HeepServletResponse对象
     * @param session HttpSession对象
     * @param file 图片对象
     * @return Map<String, Object> 上传成功返回成功信息，失败返回失败信息
     * @exception Exception 异常处理
     */
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
    /**
     * 添加商品信息
     */
    @RequestMapping(value = "/addGoods",method = RequestMethod.POST)
    @ResponseBody
    public int addGoods(WebTbGoods webTbGoods){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前系统时间
        webTbGoods.setgAddTime(df.format(new Date()));
        return webGoodsService.addGoods(webTbGoods);
    }
    /**
     * 通过商品id得到商品信息
     */
    @RequestMapping(value = "/getGoods",method = RequestMethod.GET)
    @ResponseBody
    public WebTbGoods getGoods(String gId){
        return webGoodsService.getGoods(gId);
    }
    /**
     * 修改商品信息
     */
    @RequestMapping(value = "/updateGoods",method = RequestMethod.POST)
    @ResponseBody
    public int updateGoods(GoodsDto goodsDto){
        return webGoodsService.updateGoods(goodsDto);
    }
    /**
     * 删除商品信息
     */
    @RequestMapping(value = "/delGoods",method = RequestMethod.POST)
    @ResponseBody
    public int deleteGoods(int gId){
        return webGoodsService.deleteGoods(gId);
    }
    /**
     * 删除所选商品信息
     */
    @RequestMapping(value = "/delAllGoods",method = RequestMethod.POST)
    @ResponseBody
    public int deleteAllGoods(String[] ids){
        for(int i=0;i<ids.length;i++){
            webGoodsService.deleteGoods(Integer.parseInt(ids[i]));
        }
        return 1;
    }
    /**
     * 得到一个类型的商品信息
     */
    @RequestMapping(value = "/getTypeGoods",method = RequestMethod.GET)
    @ResponseBody
    public List<WebTbGoods> getTypeGoods(Integer g_type){
        return webGoodsService.getTypeGoods(g_type);
    }
    /**
     * 通过商品名字得到商品信息
     */
    @RequestMapping(value = "/getNameGoods",method = RequestMethod.GET)
    @ResponseBody
    public List<WebTbGoods> getNameGoods(String g_name){
        return webGoodsService.getNameGoods(g_name);
    }
    /**
     * 通过添加日期得到商品信息
     */
    @RequestMapping(value = "/getDateGoods",method = RequestMethod.GET)
    public List<WebTbGoods> getDateGoods(String start,String end){
        return webGoodsService.getDateGoods(start,end);
    }
    /**
     * 通过添加日期和类型得到商品信息
     */
    @RequestMapping(value = "/getDateTypeGoods",method = RequestMethod.GET)
    public List<WebTbGoods> getDateTypeGoods(String start,String end,Integer g_type){
        return webGoodsService.getDateTypeGoods(start,end,g_type);
    }
}
