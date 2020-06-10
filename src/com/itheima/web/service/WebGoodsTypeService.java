package com.itheima.web.service;

import com.itheima.web.entity.WebTbGoodsType;

import java.util.List;

/**
 * 商品类型service层
 *
 * @author: Lv Bo
 * @create: 2020-06-08
 */
public interface WebGoodsTypeService {

    List<WebTbGoodsType> getAllGoodsType();

    int addGoodsType(String type);
}
