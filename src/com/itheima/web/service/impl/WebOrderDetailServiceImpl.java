package com.itheima.web.service.impl;

import com.itheima.web.dao.WebOrderDetailDao;
import com.itheima.web.dto.sreachorderdetaildto;
import com.itheima.web.entity.WebTbOrderDetail;
import com.itheima.web.pojo.sreachorderdetailpojo;
import com.itheima.web.service.WebOrderDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class WebOrderDetailServiceImpl implements WebOrderDetailService {
    @Resource
    WebOrderDetailDao webOrderDetailDao;

    @Override
    public List<WebTbOrderDetail> getallorder(){ return webOrderDetailDao.getallorder();}

    @Override
    public void deletbyid(Integer c_id){webOrderDetailDao.deletbyid(c_id);}

    @Override
    public Integer deleteall(String[] ids) {
        Integer[] idlist = new Integer[ids.length];
        for (int i = 0; i < ids.length; i++) {
            idlist[i] = Integer.parseInt(ids[i]);
        }
        return webOrderDetailDao.deleteall(idlist);
    }

    @Override
    public List<WebTbOrderDetail> sreachorder(sreachorderdetaildto s) throws ParseException{
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
        sreachorderdetailpojo sp = new sreachorderdetailpojo();
        sp.setStart(java.sql.Date.valueOf(s.getStart()));
        sp.setEnd(java.sql.Date.valueOf(s.getEnd()));
        sp.setUname(s.getUname());
        List<WebTbOrderDetail> list = webOrderDetailDao.sreachorder(sp);
        return list;
    }

}
