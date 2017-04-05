package com.ecsolutions.service;

import com.ecsolutions.entity.User_Entity;

/**
 * Created by Administrator on 2017/4/1.
 */
public interface User_Service {
    User_Entity findUser(String userid, String password);
}
