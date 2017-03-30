package com.ecsolutions.service;

import com.ecsolutions.dao.BackgroundCheck_DAO;
import com.ecsolutions.entity.BackgroundCheck_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@Service("BackgroundCheck_Service")
public class BackgroundCheck_ServiceImpl implements BackgroundCheck_Service {
    private BackgroundCheck_DAO backgroundCheck_dao;

    @Autowired
    public BackgroundCheck_ServiceImpl(BackgroundCheck_DAO backgroundCheck_dao) {
        this.backgroundCheck_dao = backgroundCheck_dao;
    }

    @Override
    public Long findBackgroundCheck_TotalByCustCode(String customer_code) {
        return this.backgroundCheck_dao.findBackgroundCheck_TotalByCustCode(customer_code);
    }

    @Override
    public List<BackgroundCheck_Entity> findBackgroundCheck(String customer_code, String search, String orderCol, String orderDir) {
        return this.backgroundCheck_dao.findBackgroundCheck(customer_code,search,orderCol,orderDir);
    }
}
