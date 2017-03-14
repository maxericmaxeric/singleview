package com.ecsolutions.controller;

import com.ecsolutions.entity.UserEntity;
import com.ecsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/14.
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public UserEntity getUserById(@PathVariable("id") Integer id) {
        UserEntity userEntity = userService.findUserById(id);
//        if (userEntity == null)
//            return "null";
//        return userEntity.getId() + " " + userEntity.getUsername() + " " + userEntity.getPhone();
        return userEntity;
//        return new ResponseEntity<>(userEntity, HttpStatus.OK);
    }


    /**
     * 创建用户
     * @param userEntity
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity createUser(@RequestBody UserEntity userEntity) {
        boolean created = userService.createUser(userEntity);
        if (!created) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
