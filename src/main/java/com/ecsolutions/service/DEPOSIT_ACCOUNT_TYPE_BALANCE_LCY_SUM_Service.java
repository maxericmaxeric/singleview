package com.ecsolutions.service;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
public interface DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Service {

    List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findDEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUMByCustomer_code(String customer_code);

}
