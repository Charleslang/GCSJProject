package com.itheima.user.controller;

import com.itheima.entity.TbGoods;
import com.itheima.entity.TbGoodsType;
import com.itheima.user.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;

    @GetMapping("/goods")
    public List<TbGoodsType> getAllGoods(){
        List<TbGoodsType> tbGoodsList = goodsService.getAllGoods();
        System.out.println("进入controller...");
        return tbGoodsList;
    }

    @GetMapping("/goodstypes")
    public List<TbGoodsType> getAllGoodsTypes(){
        List<TbGoodsType> tbGoodsTypeList = goodsService.getAllGoodsTypes();
        return tbGoodsTypeList;
    }
}
