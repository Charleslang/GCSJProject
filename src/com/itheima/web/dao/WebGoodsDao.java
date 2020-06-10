package com.itheima.web.dao;

import com.itheima.web.entity.WebTbGoods;

import java.util.List;

/**
 * 商品管理dao层
 *
 * @author: Lv Bo
 * @create: 2020-06-05
 **/
public interface WebGoodsDao {

    List<WebTbGoods> getAllGoods();

    int addGoods(Object o);

    WebTbGoods getGoods(String gId);

    int updateGoods(Object o);

    int deleteGoods(int gId);
}
