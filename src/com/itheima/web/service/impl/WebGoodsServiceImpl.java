package com.itheima.web.service.impl;

import com.itheima.web.dao.WebGoodsDao;
import com.itheima.web.entity.WebTbGoods;
import com.itheima.web.service.WebGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service实现层
 *
 * @author: Lv Bo
 * @create: 2020-06-05
 **/
import javax.annotation.Resource;
import java.util.List;
@Service
public class WebGoodsServiceImpl implements WebGoodsService {

    @Resource
    WebGoodsDao webGoodsDao;
    @Override
    public List<WebTbGoods> getAllGoods() {
        return webGoodsDao.getAllGoods();
    }
}
