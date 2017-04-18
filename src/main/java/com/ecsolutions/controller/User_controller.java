package com.ecsolutions.controller;

import com.ecsolutions.entity.DatatableResponse_Entity;
import com.ecsolutions.entity.Function_Entity;
import com.ecsolutions.entity.User_Entity;
import com.ecsolutions.service.User_Service;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/4/6.
 */
@RestController
@RequestMapping("users")
public class User_controller {
    @Autowired
    private User_Service user_service;

    @Autowired
    StringEncryptor stringEncryptor;

    public User_Service getUser_service() {
        return user_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping
    public String create(User_Entity user_entity) {
        try {
            user_entity.setPassword(stringEncryptor.encrypt(user_entity.getPassword()));
            user_service.createUser(user_entity);
            return "user creation success.";
        } catch (Exception ex) {
            return "user creation failed.";
        }
    }

    @PostMapping("/create2")
    public String create2(User_Entity user_entity) {
        try {
            user_service.createUser(user_entity);
            return "user creation success.";
        } catch (Exception ex) {
            return "user creation failed.";
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/{userid}")
    public User_Entity get(@PathVariable("userid") String userid) {
        return user_service.getUser(userid);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping
    public DatatableResponse_Entity queryUsers(@RequestParam(value = "draw", required = true) Integer draw,
                                  @RequestParam(value = "start", required = true) Integer start,
                                  @RequestParam(value = "length", required = true) Integer length,
                                  @RequestParam(value = "orderCol", required = true) String orderCol,
                                  @RequestParam(value = "orderDir", required = true) String orderDir,
                                  @RequestParam(value = "search", required = true) String search) {
        DatatableResponse_Entity datatableResponse_entity = new DatatableResponse_Entity(this, draw,start,length,orderCol.trim(),orderDir.trim(),search,"");
        return datatableResponse_entity;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PutMapping()
    public String modify(User_Entity user_entity) {
        try {
            user_entity.setPassword(stringEncryptor.encrypt(user_entity.getPassword()));
            user_service.update(user_entity);
            return "user update success.";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "user update failed.";
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @DeleteMapping("/{userid}")
    public String delete(@PathVariable String userid) {
        try {
            user_service.delete(userid);
            return "user delete success.";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "user delete failed.";
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/functions/{userid}")
    public List<Function_Entity> getFunctions(@PathVariable("userid") String userid) {
        return user_service.getFunctions(userid);
    }
}
