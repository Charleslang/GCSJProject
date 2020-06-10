package com.itheima.user.service;

import com.itheima.entity.TbGoods;
import com.itheima.entity.TbGoodsType;
import com.itheima.user.dto.UpdateGoodsDTO;

import java.util.List;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
public interface GoodsService {

    List<TbGoodsType> getAllGoods();
    int updateGoodsNum(List<UpdateGoodsDTO> list);
}
