package com.itheima.user.service.impl;

import com.itheima.common.redis.JedisUtil;
import com.itheima.common.utils.CommonUtils;
import com.itheima.entity.TbOrder;
import com.itheima.user.dao.UserOrderDao;
import com.itheima.user.dto.OrderDTO;
import com.itheima.user.pojo.User;
import com.itheima.user.pojo.UserOrder;
import com.itheima.user.pojo.UserOrdinary;
import com.itheima.user.pojo.UserQQ;
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
    public List<UserOrder> selectOrderList(OrderDTO orderDTO) {
        User user = CommonUtils.getCurrentUser(jedisUtil);
        if(user instanceof UserOrdinary){
            orderDTO.setUserId(((UserOrdinary)user).getmUserId()+"");
        }else{
            orderDTO.setUserId(((UserQQ)user).getmOpenid()+"");

        }

        orderDTO.setPageNum(orderDTO.getPageSize()*(orderDTO.getPageNum()-1));
        List<List<?>> sqlRes = userOrderDao.selectOrderList(orderDTO);
        return (List<UserOrder>) sqlRes.get(0);
    }
}
