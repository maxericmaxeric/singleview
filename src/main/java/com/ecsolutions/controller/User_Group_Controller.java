package com.ecsolutions.controller;

import com.ecsolutions.entity.User_Group_Entity;
import com.ecsolutions.service.User_Group_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017-4-10.
 */
@RestController
@RequestMapping("/usergroup")
public class User_Group_Controller {
    @Autowired
    private User_Group_Service user_group_service;

    public User_Group_Service getUser_Group_service() {
        return user_group_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/getUserGroup")
    public List<User_Group_Entity> getUserGroup()
    {
       List<User_Group_Entity> user_group_entities = user_group_service.findUserGroupInfo();
       return user_group_entities;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/createUserGroup")
    public String create(@RequestParam(value="groupid", defaultValue = "", required = true) String groupid,
                         @RequestParam(value="groupdesc", defaultValue = "", required = true) String groupdesc,
                         @RequestParam(value="remark", defaultValue = "", required = true) String remark) {
        try {
            user_group_service.createUserGroup(groupid,groupdesc,remark);
            return "usergroup creation success.";
        } catch (Exception ex) {
            return "usergroup creation failed.";
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/updateUserGroup")
    public String modify(@RequestParam(value="groupid", defaultValue = "", required = true) String groupid,
                         @RequestParam(value="groupdesc", defaultValue = "", required = true) String groupdesc,
                         @RequestParam(value="remark", defaultValue = "", required = true) String remark) {
        try {
            user_group_service.updateUserGroup(groupid,groupdesc,remark);
            return "usergroup update success.";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "usergroup update failed.";
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @DeleteMapping("/{groupid}")
    public String delete(@PathVariable String groupid) {
        try {
            user_group_service.deleteUserGroup(groupid);
            return "usergroup delete success.";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "usergroup delete failed.";
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/functions/{groupid}")
    public List<String> getGroupId(@PathVariable String groupid) {
        return user_group_service.getFunctions(groupid);
    }

}
