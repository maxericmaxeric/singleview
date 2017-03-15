package com.ecsolutions.service;

import com.ecsolutions.dao.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_DAO;
import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
@Service("dEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Service")
public class DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_ServiceImpl  implements DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Service{

    private final DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_DAO dEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_DAO;

    @Autowired
    public DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_ServiceImpl(DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_DAO dEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_DAO) {
        this.dEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_DAO = dEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_DAO;
    }

    @Override
    public List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findDEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUMByCustomer_code(String customer_code) {
            return dEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_DAO.findDEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUMByCustomer_code(customer_code);
    }

}
