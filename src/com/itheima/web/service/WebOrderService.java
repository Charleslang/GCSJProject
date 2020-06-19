package com.itheima.web.service;

import com.itheima.web.dto.sreachorderdto;
import com.itheima.web.entity.WebTbOrder;

import java.text.ParseException;
import java.util.List;

public interface WebOrderService {

    List<WebTbOrder> getallorder();

    void deletbyid(Integer c_id);

    Integer deleteall(String[] ids);

    List<WebTbOrder> sreachorder(sreachorderdto s) throws ParseException;

}
