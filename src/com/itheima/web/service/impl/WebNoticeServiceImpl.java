package com.itheima.web.service.impl;

import com.itheima.web.dao.WebNoticeDao;
import com.itheima.web.dto.newNotice;
import com.itheima.web.dto.sreachnoticedto;
import com.itheima.web.entity.WebTbNotice;
import com.itheima.web.pojo.notice;
import com.itheima.web.pojo.sreachnoticepojo;
import com.itheima.web.service.WebNoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WebNoticeServiceImpl implements WebNoticeService {
    @Resource
    WebNoticeDao webNoticeDao;
    @Override
    public List<WebTbNotice> getallnotice(){
       return webNoticeDao.getallnotice();
    }

    @Override
    public void deletbyid(Integer c_id) {
        webNoticeDao.deletbyid(c_id);
    }

    @Override
    public Integer deleteall(String[] ids) {
        Integer[] idlist=new Integer[ids.length];
        for (int i = 0; i < ids.length; i++) {
            idlist[i] = Integer.parseInt(ids[i]);
        }
        return webNoticeDao.deleteall(idlist);
    }

    @Override
    public List<WebTbNotice> sreachnotice(sreachnoticedto s) throws ParseException {
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
        sreachnoticepojo sp=new sreachnoticepojo();
        sp.setStart(java.sql.Date.valueOf(s.getStart()));
        sp.setEnd(java.sql.Date.valueOf(s.getEnd()));
        sp.setUname(s.getUname());
        List<WebTbNotice> list = webNoticeDao.sreachnotice(sp);
        return list;
    }

    @Override
    public int addNotice(newNotice newNotice) {
        //生成创建时间
        java.sql.Date nPubTime=new java.sql.Date(System.currentTimeMillis());
        notice notice = new notice();
        notice.setnTitle(newNotice.getnTitle());
        notice.setnContent(newNotice.getnContent());
        notice.setnPubTime(nPubTime);
        webNoticeDao.addNotice(notice);
        return 1;
    }

}
