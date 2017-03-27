package com.ecsolutions.service;

import com.ecsolutions.dao.Loan_DAO;
import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;
import com.ecsolutions.entity.Loan_Entity;
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

    @Override
    public List<Loan_Entity> findLoanByCustCode(String customer_code) {
        return loan_dao.findLoanByCustCode(customer_code);
    }

    @Override
    public Long findLoan_TotalByCustCode(String customer_code) {
        return loan_dao.findLoan_TotalByCustCode(customer_code);
    }

    @Override
    public List<Loan_Entity> findLoan(String customer_code, String search, String orderCol, String orderDir) {
        return loan_dao.findLoan(customer_code, search, orderCol, orderDir);
    }
}
