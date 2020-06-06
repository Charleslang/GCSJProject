package com.itheima.web.dao;

import com.itheima.web.entity.WebTbGoods;

import java.util.List;

/**
 * dao层
 *
 * @author: Lv Bo
 * @create: 2020-06-05
 **/
public interface WebGoodsDao {

    List<WebTbGoods> getAllGoods();
}
