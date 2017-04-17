package com.ecsolutions.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User_Entity extends Base_Entity{

    private String userid;
    private String username;
    private String password;
    private String organization;
    private String groupid;
    private String status;
    private String adminflag;


    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    @Override
    public List<Object> convertToArray() {
        List<Object> ret = new ArrayList<>();
        ret.add(userid);
        ret.add(username);
        ret.add(password);
        ret.add(organization);
        ret.add(groupid);
        ret.add(status);
        ret.add(adminflag);
        return ret;
    }
}
