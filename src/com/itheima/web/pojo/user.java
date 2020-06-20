package com.itheima.web.pojo;



import org.springframework.stereotype.Repository;

import java.sql.Date;

/**
 * @Author ChenKai
 * @Date 2020/6/11/011 10:23
 * @Version 1.0
 */
@Repository
public class user {
    private String nickname;
    private String account;
    private String email;
    private String pass;
    private String salt;
    private String gender;
    private Integer logintime;
    private java.sql.Date uCreateTime;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getuCreateTime() {
        return uCreateTime;
    }

    public void setuCreateTime(Date uCreateTime) {
        this.uCreateTime = uCreateTime;
    }
    public Integer getLogintime() {
        return logintime;
    }

    public void setLogintime(Integer logintime) {
        this.logintime = logintime;
    }

    @Override
    public String toString() {
        return "user{" +
                "nickname='" + nickname + '\'' +
                ", account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", salt='" + salt + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
