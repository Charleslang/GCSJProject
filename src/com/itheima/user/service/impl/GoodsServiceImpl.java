package com.itheima.user.service.impl;

import com.itheima.entity.TbGoods;
import com.itheima.entity.TbGoodsType;
import com.itheima.user.dao.GoodsDao;
import com.itheima.user.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<TbGoods> getAllGoods() {
        List<TbGoods> tbGoodsList = goodsDao.getAllGoods();
        return tbGoodsList;
    }

    @Override
    public List<TbGoodsType> getAllGoodsTypes() {
        List<TbGoodsType> tbGoodsTypeList = goodsDao.getAllGoodsTypes();
        return tbGoodsTypeList;
    }
}
