package com.ecsolutions.entity;

/**
 * Created by Administrator on 2017/3/14.
 */
public class UserEntity {
    // 数据表主键
    private int id;
    // 用户名
    private String username;
    // 手机号码
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
