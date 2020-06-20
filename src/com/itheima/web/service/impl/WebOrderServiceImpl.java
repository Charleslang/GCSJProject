package com.itheima.web.service.impl;

import com.itheima.web.dao.WebOrderDao;
import com.itheima.web.dto.sreachorderdto;
import com.itheima.web.entity.WebTbOrder;
import com.itheima.web.pojo.sreachorderpojo;
import com.itheima.web.service.WebOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WebOrderServiceImpl implements WebOrderService {
    @Resource
    WebOrderDao webOrderDao;
    @Override
    public List<WebTbOrder> getallorder(){
        return webOrderDao.getallorder();
    }

    @Override
    public void deletbyid(Integer c_id){
        webOrderDao.deletbyid(c_id);
    }

    @Override
    public Integer deleteall(String[] ids){
        Integer[] idlist=new Integer[ids.length];
        for (int i = 0; i < ids.length; i++) {
            idlist[i] = Integer.parseInt(ids[i]);
        }
        return webOrderDao.deleteall(idlist);
    }

    @Override
    public List<WebTbOrder> sreachorder(sreachorderdto s) throws ParseException {
        if(s.getStart().equals(""))
        {
            s.setStart("2020-5-20");
        }
        if(s.getEnd().equals(""))
        {
            Date d = new Date();
            System.out.println(d);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String nowdate = sdf.format(d);
            s.setEnd(nowdate);
        }
        String[] l=s.getStart().split("-");
        if(Integer.parseInt(l[2]) > 8 && Integer.parseInt(l[2]) < 30)
        {
            int i=Integer.parseInt(l[2])+1;
            s.setStart(l[0]+"-"+l[1]+"-"+String.valueOf(i));
        }else{
            int i=Integer.parseInt(l[2])+1;
            s.setStart(l[0]+"-"+l[1]+"-"+"0"+String.valueOf(i));
        }
        sreachorderpojo sp = new sreachorderpojo();
        sp.setStart(java.sql.Date.valueOf(s.getStart()));
        sp.setEnd(java.sql.Date.valueOf(s.getEnd()));
        sp.setUname(s.getUname());
        List<WebTbOrder> list = webOrderDao.sreachorder(sp);

        return list;
    }
}
