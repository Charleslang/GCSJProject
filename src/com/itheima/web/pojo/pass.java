package com.itheima.web.pojo;

/**
 * @Author ChenKai
 * @Date 2020/6/11/011 15:05
 * @Version 1.0
 */
public class pass {
    private String pass;
    private String salt;
    private String uid;
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
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
