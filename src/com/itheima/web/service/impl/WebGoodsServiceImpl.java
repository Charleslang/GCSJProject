package com.itheima.web.service.impl;

import com.itheima.web.dao.WebGoodsDao;
import com.itheima.web.entity.WebTbGoods;
import com.itheima.web.service.WebGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品管理service实现层
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

    @Override
    public int addGoods(Object o) {
        return webGoodsDao.addGoods(o);
    }

    @Override
    public WebTbGoods getGoods(String gId) {
        return webGoodsDao.getGoods(gId);
    }

    @Override
    public int updateGoods(Object o) {
        return webGoodsDao.updateGoods(o);
    }

    @Override
    public int deleteGoods(Integer gId) {
        return webGoodsDao.deleteGoods(gId);
    }

    @Override
    public List<WebTbGoods> getTypeGoods(Integer g_type) {
        return webGoodsDao.getTypeGoods(g_type);
    }

    @Override
    public List<WebTbGoods> getNameGoods(String g_name) {
        return webGoodsDao.getNameGoods(g_name);
    }

    @Override
    public List<WebTbGoods> getDateGoods(String start, String end) {
        System.out.println(start+end+" 1");
        return webGoodsDao.getDateGoods(start,end);
    }

    @Override
    public List<WebTbGoods> getDateTypeGoods(String start, String end, Integer g_type) {
        return webGoodsDao.getDateTypeGoods(start,end,g_type);
    }


}
