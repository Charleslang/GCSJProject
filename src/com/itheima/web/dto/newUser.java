package com.itheima.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author ChenKai
 * @Date 2020/6/10/010 16:37
 * @Version 1.0
 */
public class newUser {
    private String nickname;
    private String gender;
    private String email;
    private String pass;

    public String getNickname() {
        return nickname;
    }
     @JsonProperty(value = "nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }
@JsonProperty(value = "gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }
@JsonProperty(value = "email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }
@JsonProperty(value = "pass")
    public void setPass(String pass) {
        this.pass = pass;
    }


    @Override
    public String toString() {
        return "newUser{" +
                "nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
