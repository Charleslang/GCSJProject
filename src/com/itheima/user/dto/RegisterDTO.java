package com.itheima.user.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
public class RegisterDTO {
    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空")
    private String nickname;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空")
    private String gender;
    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空")
    private String email;


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
