package com.ecsolutions.service;

import com.ecsolutions.dao.User_DAO;
import com.ecsolutions.entity.User_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Long findUserCount() {
        return user_dao.findUserCount();
    }

    @Override
    public List<User_Entity> findUserList(String search, String orderCol, String orderDir) {
        return user_dao.findUserList(search, orderCol, orderDir);
    }

    @Override
    public void update(User_Entity user_entity) {
        user_dao.update(user_entity);
}

    @Override
    public void delete(String userid) {
        user_dao.delete(userid);
    }
}
