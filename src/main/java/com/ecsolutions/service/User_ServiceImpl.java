package com.ecsolutions.service;

import com.ecsolutions.dao.User_DAO;
import com.ecsolutions.entity.User_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/1.
 */
@Service("User_Service")
public class User_ServiceImpl implements User_Service {
    private User_DAO user_dao;

    @Autowired
    public User_ServiceImpl(User_DAO user_dao) {
        this.user_dao = user_dao;
    }

    @Override
    public User_Entity findUser(String userid, String password) {
        return user_dao.findUser(userid, password);
    }

    @Override
    public void createUser(User_Entity user_entity){
        user_dao.createUser(user_entity);
    }

    @Override
    public User_Entity getUser(String userid) {
        return user_dao.getUser(userid);
    }
}
