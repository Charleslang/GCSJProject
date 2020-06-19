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
    /**
     * 得到所有商品类型信息
     */
    @RequestMapping(value="/getAllGoodsType",method = RequestMethod.GET)
    @ResponseBody
    public List<WebTbGoodsType> getAllGoodsType(){
        return webGoodsTypeService.getAllGoodsType();
    }
    /**
     *添加一个商品类型
     */
    @RequestMapping(value = "/addGoodsType",method = RequestMethod.POST)
    @ResponseBody
    public int addGoodsType(String type){
        return webGoodsTypeService.addGoodsType(type);
    }
}
