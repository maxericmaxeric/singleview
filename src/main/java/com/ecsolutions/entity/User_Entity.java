package com.ecsolutions.entity;

/**
 * Created by Administrator on 2017/4/1.
 */
public class User_Entity {
    private String userid;
    private String username;
    private String status;
    private String adminflag;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdminflag() {
        return adminflag;
    }

    public void setAdminflag(String adminflag) {
        this.adminflag = adminflag;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
