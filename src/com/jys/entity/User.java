package com.jys.entity;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class User {
    /**
    int 默认是0  Integer默认是null
     */
    private Integer uid;
    private String name;
    private String sex;
    private String password;
    private String email;
    private String phone;
    private String isAdmin;

    public User() {
    }

    public User(Integer uid, String name, String sex, String password, String email, String phone, String isAdmin) {
        this.uid = uid;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.isAdmin = isAdmin;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                '}';
    }
}
