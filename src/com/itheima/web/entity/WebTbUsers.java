package com.itheima.web.entity;

/**
 * @Author ChenKai
 * @Date 2020/6/5/005 21:07
 * @Version 1.0
 */
public class WebTbUsers {
    private Integer uId;
    private String uNickname;
    private String uPassword;
    private String uGender;
    private String uSalt;
    private String uEmail;
    private String uProfile;
    private java.sql.Date uCreateTime;
    private Integer uLoginTime;


    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }


    public String getUNickname() {
        return uNickname;
    }

    public void setUNickname(String uNickname) {
        this.uNickname = uNickname;
    }



    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }


    public String getUGender() {
        return uGender;
    }

    public void setUGender(String uGender) {
        this.uGender = uGender;
    }


    public String getUSalt() {
        return uSalt;
    }

    public void setUSalt(String uSalt) {
        this.uSalt = uSalt;
    }


    public String getUEmail() {
        return uEmail;
    }

    public void setUEmail(String uEmail) {
        this.uEmail = uEmail;
    }


    public String getUProfile() {
        return uProfile;
    }

    public void setUProfile(String uProfile) {
        this.uProfile = uProfile;
    }


    public java.sql.Date getUCreateTime() {
        return uCreateTime;
    }

    public void setUCreateTime(java.sql.Date uCreateTime) {
        this.uCreateTime = uCreateTime;
    }


    public Integer getULoginTime() {
        return uLoginTime;
    }

    public void setULoginTime(Integer uLoginTime) {
        this.uLoginTime = uLoginTime;
    }
}
