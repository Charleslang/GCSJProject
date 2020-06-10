package com.itheima.web.dao;

import com.itheima.web.entity.WebTbGoodsType;

import java.util.List;

/**
 * 商品类型dao层
 *
 * @author: Lv Bo
 * @create: 2020-06-08
 */
public interface WebGoodsTypeDao {

    List<WebTbGoodsType> getAllGoodsType();

    int addGoodsType(String type);
}
