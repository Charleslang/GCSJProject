package com.itheima.web.dto;

/**
 * @Author ChenKai
 * @Date 2020/6/12/012 14:54
 * @Version 1.0
 */
public class newpass {
    private String oldpass;
    private String newpass;
    private String uid;
    public String getOldpass() {
        return oldpass;
    }

    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "newpass{" +
                "oldpass='" + oldpass + '\'' +
                ", newpass='" + newpass + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}
