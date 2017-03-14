package com.ecsolutions.service;

import com.ecsolutions.entity.UserEntity;

/**
 * Created by Administrator on 2017/3/14.
 */
public interface UserService {
    // 创建新用户
    boolean createUser(UserEntity userEntity);
    // 根据主键id查找用户
    UserEntity findUserById(int id);
}
