package com.shiqing.hashImage.bean;


/**
 * @author：xiaoyu
 * @create： 11:28 2019/5/11
 * @description:
 */
public class User {

    private Long id;

    private String password;

    private String userName;

    private Boolean userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getUserType() {
        return userType;
    }

    public void setUserType(Boolean userType) {
        this.userType = userType;
    }
}
