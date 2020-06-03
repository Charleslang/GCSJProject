package com.itheima.user.service.impl;

import com.itheima.common.redis.JedisUtil;
import com.itheima.entity.TbOrder;
import com.itheima.user.dao.UserOrderDao;
import com.itheima.user.dto.OrderDTO;
import com.itheima.user.service.UserOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {
    @Resource
    private UserOrderDao userOrderDao;
    @Resource
    private JedisUtil jedisUtil;


    @Override
    public List<TbOrder> selectOrderList(OrderDTO orderDTO) {
        orderDTO.setPageNum(orderDTO.getPageSize()*(orderDTO.getPageNum()-1));
        List<List<?>> sqlRes = userOrderDao.selectOrderList(orderDTO);
        return (List<TbOrder>) sqlRes.get(0);
    }
}
