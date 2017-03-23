package com.ecsolutions.service;

import com.ecsolutions.dao.Loan_DAO;
import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
@Service("loan_service")
public class Loan_ServiceImpl  implements  Loan_Service{
    private final Loan_DAO loan_dao;

    @Autowired
    public Loan_ServiceImpl(Loan_DAO loan_dao) {
        this.loan_dao = loan_dao;
    }

    @Override
    public List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findLoan_Ccy_SumByCustCode(String customer_code) {
        return loan_dao.findLoan_Ccy_SumByCustCode(customer_code);
    }

    @Override
    public List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findLoan_Type_SumByCustCode_CCY(String customer_code, String currency) {
        return loan_dao.findLoan_Type_SumByCustCode_CCY(customer_code, currency);
    }
}
