package com.itheima.web.service;

import com.itheima.web.entity.WebTbGoods;

import java.util.List;

/**
 * 商品管理service层
 *
 * @author: Lv Bo
 * @create: 2020-06-06
 */
public interface WebGoodsService {

    List<WebTbGoods> getAllGoods();

    int addGoods(Object o);

    WebTbGoods getGoods(String gId);

    int updateGoods(Object o);

    int deleteGoods(Integer gId);
}
