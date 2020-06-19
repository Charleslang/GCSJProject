package com.itheima.web.dao;

import com.itheima.web.entity.WebTbGoodsType;

import java.util.List;

/**
 * 商品类型dao层
 *
 * @author Lv Bo
 * @create 2020-06-08
 * @version 1.0
 */
public interface WebGoodsTypeDao {
    /**
     *得到所有的商品类型
     * @return List<WebTbGoodsType>，查询成功返回该类型的所有商品信息，若查询失败则返回null
     */
    List<WebTbGoodsType> getAllGoodsType();
    /**
     *添加商品类型
     * @param type 商品类型
     * @return int，添加成功返回1，添加失败或者有同名类型返回0
     */
    int addGoodsType(String type);
}
