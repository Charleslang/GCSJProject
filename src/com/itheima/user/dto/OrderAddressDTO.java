package com.itheima.user.dto;

public class OrderAddressDTO {
    private String aDetails;
    private String aPhone;
    private String aUserId;
    private String aUsername;
    private Integer userType;

    public String getaUsername() {
        return aUsername;
    }

    public void setaUsername(String aUsername) {
        this.aUsername = aUsername;
    }

    public String getaDetails() {
        return aDetails;
    }

    public void setaDetails(String aDetails) {
        this.aDetails = aDetails;
    }

    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    public String getaUserId() {
        return aUserId;
    }

    public void setaUserId(String aUserId) {
        this.aUserId = aUserId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "OrderAddressDTO{" +
                "aDetails='" + aDetails + '\'' +
                ", aPhone='" + aPhone + '\'' +
                ", aUserId='" + aUserId + '\'' +
                ", aUsername='" + aUsername + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
