package com.itheima.user.service.impl;

import com.itheima.entity.TbOrderDetails;
import com.itheima.user.dao.GoodsDao;
import com.itheima.user.dao.OrderDao;
import com.itheima.user.dao.OrderDetailsDao;
import com.itheima.user.dto.InsertOrderDTO;
import com.itheima.user.dto.OrderDetailsDTO;
import com.itheima.user.dto.UpdateGoodsDTO;
import com.itheima.user.dto.UpdateOrderDTO;
import com.itheima.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: Dai Junfeng
 * @create: 2020-06-02
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private GoodsServiceImpl goodsService;

    @Override
    @Transactional
    public InsertOrderDTO insertOrder(InsertOrderDTO insertOrderDTO) {
        List<OrderDetailsDTO> orderDetailsList = insertOrderDTO.getOrderDetailsList();
        List<UpdateGoodsDTO> updateGoodsDTOList = new ArrayList<>();
        int insert = orderDao.insertOrder(insertOrderDTO);
        if (insert == 1) {
            System.out.println("订单插入成功");
            int orderId = insertOrderDTO.getOrderId();
            System.out.println("orderId->" + orderId);
            for (OrderDetailsDTO details : orderDetailsList) {
                details.setOrderId(orderId);
                updateGoodsDTOList.add(new UpdateGoodsDTO(details.getGoodsId(),details.getStockNum()));
            }
            int count = orderDetailsDao.insertOrderDetail(orderDetailsList);
            System.out.println("插入订单条数->" + count);
            if (count == orderDetailsList.size()){
                System.out.println("订单详情插入成功");
                int update = goodsService.updateGoodsNum(updateGoodsDTOList);{
                    if (update == updateGoodsDTOList.size()){
                        System.out.println("商品库存修改成功");
                        System.out.println("库存修改条数->" + update);
                        return insertOrderDTO;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Map<String, Boolean> updateOrderStatus(UpdateOrderDTO updateOrderDTO) {
        int update = orderDao.updateOrderStatus(updateOrderDTO);
        Map<String,Boolean> resultMap = null;
        if (update == 1) {
            resultMap.put("code", true);
        } else {
            resultMap.put("code", false);
        }
        return resultMap;
    }
}
