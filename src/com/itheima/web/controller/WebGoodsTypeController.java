package com.itheima.web.controller;

import com.itheima.web.entity.WebTbGoodsType;
import com.itheima.web.service.WebGoodsTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品类型controller层
 *
 * @author: Lv Bo
 * @create: 2020-06-08
 **/
@CrossOrigin
@RestController
@RequestMapping("/webGoodsType")
public class WebGoodsTypeController {
    @Resource
    WebGoodsTypeService webGoodsTypeService;

    @RequestMapping(value="/getAllGoodsType",method = RequestMethod.GET)
    @ResponseBody
    public List<WebTbGoodsType> getAllGoodsType(){
        return webGoodsTypeService.getAllGoodsType();
    }

    @RequestMapping(value = "/addGoodsType",method = RequestMethod.POST)
    @ResponseBody
    public int addGoodsType(String type){
        return webGoodsTypeService.addGoodsType(type);
    }
}
