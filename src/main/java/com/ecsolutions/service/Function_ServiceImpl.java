package com.ecsolutions.service;

import com.ecsolutions.dao.Function_DAO;
import com.ecsolutions.entity.Function_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */
@Service("Function_Service")
public class Function_ServiceImpl implements Function_Service {

    private Function_DAO function_dao;

    @Autowired
    public Function_ServiceImpl(Function_DAO function_dao) {
        this.function_dao = function_dao;
    }

    @Override
    public List<Function_Entity> getFunctions() {

        return function_dao.getFunctions();
    }
}
