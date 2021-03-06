package com.ecsolutions.service;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;
import com.ecsolutions.entity.Loan_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
public interface Loan_Service {

    List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findLoan_Ccy_SumByCustCode(String customer_code);
    List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findLoan_Type_SumByCustCode_CCY(String customer_code, String currency);
    List<Loan_Entity> findLoanByCustCode(String customer_code);

    Long findLoan_TotalByCustCode(String customer_code);

    List<Loan_Entity> findLoan(String customer_code, String search, String orderCol, String orderDir);

    List<String> findLoan_BranchByCustCode(String customer_code);

    List<String> findLoan_TypeByCustCode(String customer_code);

    List<String> findLoan_PrinCCYByCustCode(String customer_code);

    List<String> findLoan_BalCCYByCustCode(String customer_code);

    List<String> findLoan_AccStatusByCustCode(String customer_code);
}
