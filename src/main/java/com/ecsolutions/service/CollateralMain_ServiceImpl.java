package com.ecsolutions.service;

import com.ecsolutions.dao.CollateralMain_DAO;
import com.ecsolutions.entity.CollateralMain_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@Service("CollateralMain_Service")
public class CollateralMain_ServiceImpl implements CollateralMain_Service{
    private CollateralMain_DAO collateralMain_dao;

    @Autowired
    public CollateralMain_ServiceImpl(CollateralMain_DAO collateralMain_dao) {
        this.collateralMain_dao = collateralMain_dao;
    }

    @Override
    public List<String> findCollateralTypeByCustCode(String customer_code) {
        return collateralMain_dao.findCollateralTypeByCustCode(customer_code);
    }

    @Override
    public List<String> findValCurrencyByCustCode(String customer_code) {
        return collateralMain_dao.findValCurrencyByCustCode(customer_code);
    }

    @Override
    public Long findCollateralMain_TotalByCustCode(String customer_code) {
        return collateralMain_dao.findCollateralMain_TotalByCustCode(customer_code);
    }

    @Override
    public List<CollateralMain_Entity> findCollateralMain(String customer_code, String search, String orderCol, String orderDir) {
        return collateralMain_dao.findCollateralMain(customer_code,search,orderCol,orderDir);
    }
}
