package com.itheima.web.controller;

import com.itheima.web.entity.WebTbGoods;
import com.itheima.web.service.WebGoodsService;
import com.itheima.web.service.impl.WebGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * controller层
 *
 * @author: Lv Bo
 * @create: 2020-06-05
 **/
@RestController
@RequestMapping("/webGoods")
public class WebGoodsController {
    @Resource
    private WebGoodsService webGoodsService;

    @GetMapping("/goods")
    public List<WebTbGoods> getAllGoods(){
        List<WebTbGoods> tbGoodsList = webGoodsService.getAllGoods();
        return tbGoodsList;
    }

}
