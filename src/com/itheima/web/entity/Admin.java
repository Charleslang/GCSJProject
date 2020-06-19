package com.itheima.web.entity;

/**
 * 管理员实体类
 *
 * @author Lv Bo
 * @create 2020-06-05
 * @version 1.0
 **/
public class Admin {
    private Integer aId;
    private String aAccount;
    private String aPassword;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaAccount() {
        return aAccount;
    }

    public void setaAccount(String aAccount) {
        this.aAccount = aAccount;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aId=" + aId +
                ", aAccount='" + aAccount + '\'' +
                ", aPassword='" + aPassword + '\'' +
                '}';
    }
}
