package com.jys.entity;

/**
 * @author jiayusheng
 * @version 1.0
 * @since 1.0
 */
public class Admin {
    private int aid;
    private String phone;
    private String password;

    public Admin() {
    }

    public Admin( String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "admin{" +
                "aid=" + aid +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
