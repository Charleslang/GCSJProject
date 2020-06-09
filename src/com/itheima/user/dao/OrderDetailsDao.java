package com.itheima.user.dao;

import com.itheima.entity.TbOrderDetails;
import com.itheima.user.dto.OrderDetailsDTO;

import java.util.List;

public interface OrderDetailsDao {
    int insertOrderDetail(List<OrderDetailsDTO> detailsList);
}
