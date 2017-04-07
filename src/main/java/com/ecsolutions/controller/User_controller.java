package com.ecsolutions.controller;

import com.ecsolutions.entity.User_Entity;
import com.ecsolutions.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/4/6.
 */
@Controller
@RequestMapping("users")
public class User_controller {
    @Autowired
    private User_Service user_service;

    public User_Service getUser_service() {
        return user_service;
    }

    @PostMapping("/create")
    public String create(@RequestBody User_Entity user_entity) {
        user_service.createUser(user_entity);
        return null;
    }

    @PostMapping("/create2")
    public String create2(User_Entity user_entity) {
        user_service.createUser(user_entity);
        return null;
    }

    @GetMapping("/{userid}")
    public User_Entity get(@PathVariable("userid") String userid) {
        return user_service.getUser(userid);
    }
}
