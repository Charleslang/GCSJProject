package com.itheima.web.controller;

import com.alibaba.fastjson.JSON;
import com.itheima.common.validator.DTOValidatorAnnotation;
import com.itheima.web.entity.WebTbGoods;
import com.itheima.web.service.WebGoodsService;
import com.itheima.web.service.impl.WebGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * controller层
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

    //@DTOValidatorAnnotation
    @RequestMapping(value="/goods",method = RequestMethod.GET)
    @ResponseBody
    public List<WebTbGoods> getAllGoods(){
        List<WebTbGoods> tbGoodsList = webGoodsService.getAllGoods();
        //String jsonpCallback = request.getParameter("callback");
        //return jsonpCallback+"("+tbGoodsList+")";
        //String ab =tbGoodsList.get(0).toString().replace("=",":");

        //response.setHeader("Access-Control-Allow-Origin", "*");
        //String str=JSON.toJSON(tbGoodsList).toString();
        //return "callback"+"("+ab+")";
        //return "success_jsonpCallback"+"("+str+")";
        return tbGoodsList;
    }

}
