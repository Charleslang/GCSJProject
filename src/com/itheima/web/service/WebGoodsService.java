package com.itheima.web.service;

import com.itheima.web.entity.WebTbGoods;

import java.util.List;

/**
 * 商品管理service层
 *
 * @author Lv Bo
 * @create 2020-06-06
 * @version 1.0
 */
public interface WebGoodsService {
    /**
     *定义得到所有商品信息的抽象方法
     */
    List<WebTbGoods> getAllGoods();
    /**
     *定义添加商品信息的抽象方法
     */
    int addGoods(Object o);
    /**
     *定义通过商品id得到商品信息的抽象方法
     */
    WebTbGoods getGoods(String gId);
    /**
     *定义修改商品信息的抽象方法
     */
    int updateGoods(Object o);
    /**
     *定义删除商品信息的抽象方法
     */
    int deleteGoods(Integer gId);
    /**
     *定义通过类型得到商品信息的抽象方法
     */
    List<WebTbGoods> getTypeGoods(Integer g_type);
    /**
     *定义通过名字得到商品信息的抽象方法
     */
    List<WebTbGoods> getNameGoods(String g_name);
    /**
     *定义通过开始时间和结束时间得到商品信息的抽象方法
     */
    List<WebTbGoods> getDateGoods(String start,String end);
    /**
     *定义通过开始时间和结束时间及商品类型得到商品信息的抽象方法
     */
    List<WebTbGoods> getDateTypeGoods(String start,String end,Integer g_type);
}
