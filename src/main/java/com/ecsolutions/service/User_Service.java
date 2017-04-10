package com.ecsolutions.service;

import com.ecsolutions.entity.User_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface User_Service {
    User_Entity findUser(String userid, String password);

    void createUser(User_Entity user_entity);

    User_Entity getUser(String userid);

    Long findUserCount();

    List<User_Entity> findUserList(String search, String orderCol, String orderDir);

    void update(User_Entity user_entity);

    void delete(String userid);
}
