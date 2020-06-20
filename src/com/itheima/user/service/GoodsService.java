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

    /**
     * 功能描述：查询所有商品信息
     * @return java.util.List;
     */
    List<TbGoodsType> getAllGoods();

    /**
     * 功能描述：更新商品库存
     * @param list 待更新的商品集合
     * @return 更新成功的数量
     */
    int updateGoodsNum(List<UpdateGoodsDTO> list);
}
