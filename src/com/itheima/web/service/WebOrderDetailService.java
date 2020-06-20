package com.itheima.web.service;

import com.itheima.web.dto.sreachorderdetaildto;
import com.itheima.web.entity.WebTbOrderDetail;

import java.text.ParseException;
import java.util.List;

public interface WebOrderDetailService {
    List<WebTbOrderDetail> getallorder();
    void deletbyid(Integer c_id);
    Integer deleteall(String[] ids);
    List<WebTbOrderDetail> sreachorder(sreachorderdetaildto s) throws ParseException;
}
