package com.itheima.web.service.impl;

import com.itheima.web.dao.WebGoodsTypeDao;
import com.itheima.web.entity.WebTbGoodsType;
import com.itheima.web.service.WebGoodsTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品类型service实现层
 *
 * @author Lv Bo
 * @create 2020-06-08
 * @version 1.0
 */
@Service
public class WebGoodsTypeServiceImpl implements WebGoodsTypeService {

    @Resource
    WebGoodsTypeDao webGoodsTypeDao;
    @Override
    public List<WebTbGoodsType> getAllGoodsType(){
        return webGoodsTypeDao.getAllGoodsType();
    }

    @Override
    public int addGoodsType(String type) {
        return webGoodsTypeDao.addGoodsType(type);
    }

}
