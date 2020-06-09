package com.itheima.user.dao;

import com.itheima.entity.TbGoodsType;
import com.itheima.user.dto.UpdateGoodsDTO;

import java.util.List;

public interface GoodsDao {

    List<TbGoodsType> getAllGoods();
    int updateGoodsNum(List<UpdateGoodsDTO> list);
}
