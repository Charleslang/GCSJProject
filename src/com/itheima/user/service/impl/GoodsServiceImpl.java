package com.itheima.user.service.impl;

import com.itheima.entity.TbGoods;
import com.itheima.entity.TbGoodsType;
import com.itheima.user.dao.GoodsDao;
import com.itheima.user.dto.GoodsDTO;
import com.itheima.user.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodsDao goodsDao;

    @Override
    public List<TbGoodsType> getAllGoods() {
        List<TbGoodsType> tbGoodsList = goodsDao.getAllGoods();
        for (TbGoodsType tbGoodsType : tbGoodsList) {
            System.out.println("商品类型: " + tbGoodsType.getTypeId() + ":" + tbGoodsType.getTypeName());
            for (GoodsDTO tbGoods : tbGoodsType.getTbGoodsList()) {
                System.out.println("商品类型 " + tbGoodsType.getTypeId() + "->" + tbGoods.toString());
            }
        }
        return tbGoodsList;
    }

    @Override
    public List<TbGoodsType> getAllGoodsTypes() {
        List<TbGoodsType> tbGoodsTypeList = goodsDao.getAllGoodsTypes();
        return tbGoodsTypeList;
    }
}
