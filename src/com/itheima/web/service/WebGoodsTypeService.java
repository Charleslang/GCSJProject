package com.itheima.web.service;

import com.itheima.web.entity.WebTbGoodsType;

import java.util.List;

/**
 * 商品类型service层
 *
 * @author Lv Bo
 * @create 2020-06-08
 * @version 1.0
 */
public interface WebGoodsTypeService {
    /**
     *定义得到所有商品类型的抽象方法
     */
    List<WebTbGoodsType> getAllGoodsType();
    /**
     *定义添加商品类型的抽象方法
     */
    int addGoodsType(String type);
}
