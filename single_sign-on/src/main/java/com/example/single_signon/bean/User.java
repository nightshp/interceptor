package com.example.single_signon.bean;

/**
 * 用户bean
 *
 * @author nightwalker
 */
public class User {

    /**
     * Id
     */
    private Integer uId;
    /**
     * 用户名
     */
    private String uName;

    /**
     * 密码
     */
    private String uPassword;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                '}';
    }
}
