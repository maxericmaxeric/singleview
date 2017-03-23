package com.ecsolutions.service;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
public interface Loan_Service {

    List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findLoan_Ccy_SumByCustCode(String customer_code);
    List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findLoan_Type_SumByCustCode_CCY(String customer_code, String currency);

}
