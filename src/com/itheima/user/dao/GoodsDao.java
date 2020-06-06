package com.itheima.user.dao;

import com.itheima.entity.TbGoods;
import com.itheima.entity.TbGoodsType;

import java.util.List;

public interface GoodsDao {

    List<TbGoodsType> getAllGoods();
    List<TbGoodsType> getAllGoodsTypes();
}
