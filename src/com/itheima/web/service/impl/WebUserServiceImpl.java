package com.itheima.web.service.impl;

import com.itheima.web.dao.WebUserDao;
import com.itheima.web.dto.newUser;
import com.itheima.web.dto.newpass;
import com.itheima.web.dto.usersreachdto;
import com.itheima.web.entity.WebTbComments;
import com.itheima.web.entity.WebTbUsers;
import com.itheima.web.pojo.pass;
import com.itheima.web.pojo.sreachcommentspojo;
import com.itheima.web.pojo.user;
import com.itheima.web.pojo.usersreachpojo;
import com.itheima.web.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.itheima.common.utils.PBKDF2Util.*;

/**
 * @Author ChenKai
 * @Date 2020/6/5/005 21:43
 * @Version 1.0
 */
@Service
public class WebUserServiceImpl implements WebUserService {
    @Resource
    WebUserDao webUserDao;


    @Override
    public List<WebTbUsers> getallusers() {
        return webUserDao.getalluser();
    }

    @Override
    public void deleteuserbyid(int u_id) {
        webUserDao.deleteuserbyid(u_id);
    }

    @Override
    public int adduser(newUser newuser) {
        //验证邮箱是否存在
        if ( webUserDao.selectuserbyemail(newuser.getEmail()) != null)
        {
            return 0;
        }
        //生成唯一账号
        String[] chars36 = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++)
        {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            // 如果是 chars62,则是x%62
            shortBuffer.append(chars36[x % 36]);
        }
        String account=shortBuffer.toString();
        //生成创建时间
        java.sql.Date createtime=new java.sql.Date(System.currentTimeMillis());
        //得到盐值，加密密码
        String salt = null;
        try {
            salt = generateSalt();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String pass = null;
        try {
            pass = getEncryptedPassword(newuser.getPass(), salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        //
        user user=new user();
        user.setAccount(account);
        user.setEmail(newuser.getEmail());
        user.setPass(pass);
        user.setSalt(salt);
        user.setGender(newuser.getGender());
        user.setNickname(newuser.getNickname());
        user.setLogintime(0);
        user.setuCreateTime(createtime);
        System.out.println(user.toString());
        webUserDao.adduser(user);
        return 1;
    }

    @Override
    public int deleteusers(String[] list) {
        Integer[] userlist=new Integer[list.length];
        for(int i=0;i<list.length;i++){
            userlist[i]=Integer.parseInt(list[i]);
        }
        return webUserDao.deleteusers(userlist);
    }

    @Override
    public int updatepass(newpass newpass) throws InvalidKeySpecException, NoSuchAlgorithmException {
        pass pass = webUserDao.getpassbyid(Integer.parseInt(newpass.getUid()));
        if (authenticate(newpass.getOldpass(), pass.getPass(), pass.getSalt())) {
            String salt = generateSalt();
            pass pass1 = new pass();
            pass1.setSalt(salt);
            pass1.setPass(getEncryptedPassword(newpass.getNewpass(), salt));
            pass1.setUid(newpass.getUid());
            return webUserDao.updatepass(pass1);
        }
        return 0;
    }

    @Override
    public List<WebTbUsers> finduser(usersreachdto ud) {
        if(ud.getStart().equals(""))
        {
            ud.setStart("2020-5-20");
        }
        if(ud.getEnd().equals(""))
        {
            Date d = new Date();
            System.out.println(d);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String nowdate = sdf.format(d);
            ud.setEnd(nowdate);
        }
         String[] l1=ud.getEnd().split("-");
        if(Integer.parseInt(l1[2]) > 8 && Integer.parseInt(l1[2]) < 30)
        {
            int i=Integer.parseInt(l1[2])+1;
            ud.setEnd(l1[0]+"-"+l1[1]+"-"+String.valueOf(i));
        }else{
            int i=Integer.parseInt(l1[2])+1;
            ud.setEnd(l1[0]+"-"+l1[1]+"-"+"0"+String.valueOf(i));
        }
        String[] l=ud.getStart().split("-");
        if(Integer.parseInt(l[2]) > 8 && Integer.parseInt(l[2]) < 30)
        {
            int i=Integer.parseInt(l[2])+1;
            ud.setStart(l[0]+"-"+l[1]+"-"+String.valueOf(i));
        }else{
            int i=Integer.parseInt(l[2])+1;
            ud.setStart(l[0]+"-"+l[1]+"-"+"0"+String.valueOf(i));
        }
        usersreachpojo sp=new usersreachpojo();
        sp.setStart(java.sql.Date.valueOf(ud.getStart()));
        sp.setEnd(java.sql.Date.valueOf(ud.getEnd()));
        sp.setUname(ud.getUname());
        List<WebTbUsers> list = webUserDao.finduser(sp);
        return list;
    }
}
