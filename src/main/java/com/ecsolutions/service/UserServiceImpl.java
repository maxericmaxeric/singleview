package com.ecsolutions.service;

import com.ecsolutions.entity.UserEntity;
import com.ecsolutions.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service("userService") // 命名bean别名
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    // 依赖注入
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    /**
     *  创建新用户
     * @param userEntity
     * @return
     */
    @Override
    public boolean createUser(UserEntity userEntity) {
        userDAO.insertUser(userEntity);
        if (userEntity.getId() > 0) {
            return true;
        }
        return false;
    }


    /**
     *  根据id查询用户
     * @param id
     * @return
     */
    @Override
    public UserEntity findUserById(int id) {
        return userDAO.findUserById(id);
    }
}
