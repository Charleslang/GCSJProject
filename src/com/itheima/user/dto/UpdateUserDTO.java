package com.itheima.user.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
  * 更新用户信息
  *
  * @author: qinjie
 **/
public class UpdateUserDTO {
    @NotBlank(message = "昵称不能为空")
    private String nickname;

    @NotBlank(message = "性别不能为空")
    private String gender;
    /**
     * 头像保存地址
     */
    private String profile;


    /**
     * 密码
     */
    private String password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
