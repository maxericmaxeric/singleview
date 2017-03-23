package com.ecsolutions.dao;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
@Repository
public interface Loan_DAO {

    // 根据customer_code查询currency, sum(amount)
    @Select("SELECT Balance_Currency TYPE, SUM(Balance) SUM from LOAN_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code}  GROUP BY Balance_Currency")
    @ResultType(DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity.class)
    List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findLoan_Ccy_SumByCustCode(@Param("customer_code") String customer_code);

    // 根据customer_code, currency查询account_type, sum(amount)
    @Select("select  Loan_Type TYPE, SUM(Balance) SUM from LOAN_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code} AND Balance_Currency = #{currency}  GROUP BY Loan_Type")
    @ResultType(DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity.class)
    List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findLoan_Type_SumByCustCode_CCY(@Param("customer_code") String customer_code, @Param("currency") String currency);


}
