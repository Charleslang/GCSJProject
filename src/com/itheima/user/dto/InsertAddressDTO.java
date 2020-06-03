package com.itheima.user.dto;

import javax.validation.constraints.NotBlank;

public class InsertAddressDTO {
    /**
     * 详细地址
     */
    @NotBlank(message = "详细地址不能为空")
    private String details;
    /**
     * 所在大学
     */
    @NotBlank(message = "所在大学不能为空")
    private String university;


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

}
