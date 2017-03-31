package com.ecsolutions.service;

import com.ecsolutions.dao.CreditLineMain_DAO;
import com.ecsolutions.entity.CreditLineMain_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@Service("CreditLineMain_Service")
public class CreditLineMain_ServiceImpl implements CreditLineMain_Service{
    private CreditLineMain_DAO creditLineMain_dao;

    @Autowired
    public CreditLineMain_ServiceImpl(CreditLineMain_DAO creditLineMain_dao) {
        this.creditLineMain_dao = creditLineMain_dao;
    }

    @Override
    public Long findCreditLineMain_TotalByCustCode(String customer_code) {
        return creditLineMain_dao.findCreditLineMain_TotalByCustCode(customer_code);
    }

    @Override
    public List<CreditLineMain_Entity> findCreditLineMain(String customer_code, String search, String orderCol, String orderDir) {
        return creditLineMain_dao.findCreditLineMain(customer_code,search, orderCol, orderDir);
    }

    @Override
    public List<String> findCurrencyByCustCode(String customer_code) {
        return creditLineMain_dao.findCurrencyByCustCode(customer_code);
    }

    @Override
    public List<String> findRevolvingIndByCustCode(String customer_code) {
        return creditLineMain_dao.findRevolvingIndByCustCode(customer_code);
    }
}
