package com.ecsolutions.dao;

import com.ecsolutions.dao.sqlProvider.Loan_sqlProvider;
import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;
import com.ecsolutions.entity.Loan_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
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

    //根据customer_code查询loan info
    @Select("select Branch,Principal_Currency,LN_Account_No,Customer_Code,Loan_Type,Line_No,Principal_Amount,Balance,Value_Date,Maturity_Date,Balance_Currency,Account_Status from LOAN_ACCOUNT_INFO where Customer_Code = #{customer_code}")
    @ResultType(Loan_Entity.class)
    List<Loan_Entity> findLoanByCustCode(@Param("customer_code") String customer_code);

    //根据customer_code查询Loan info记录总数
    @Select("select count(*) from LOAN_ACCOUNT_INFO where Customer_Code = #{customer_code}")
    @ResultType(Long.class)
    Long findLoan_TotalByCustCode(String customer_code);

    //根据customer_code,seach条件，order条件查询loan info
    @SelectProvider(type = Loan_sqlProvider.class, method = "getLoan_Sql")
    @ResultType(Loan_Entity.class)
    List<Loan_Entity> findLoan(@Param("customer_code") String customer_code,
                               @Param("search") String search,
                               @Param("orderCol") String orderCol,
                               @Param("orderDir") String orderDir);

    @Select("select distinct BRANCH from LOAN_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code} order by BRANCH")
    @ResultType(String.class)
    List<String> findLoan_BranchByCustCode(@Param("customer_code") String customer_code);

    @Select("select distinct Loan_Type from LOAN_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code} order by Loan_Type")
    @ResultType(String.class)
    List<String> findLoan_TypeByCustCode(@Param("customer_code") String customer_code);

    @Select("select distinct Principal_Currency from LOAN_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code} order by Principal_Currency")
    @ResultType(String.class)
    List<String> findLoan_PrinCCYByCustCode(@Param("customer_code") String customer_code);

    @Select("select distinct Balance_Currency from LOAN_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code} order by Balance_Currency")
    @ResultType(String.class)
    List<String> findLoan_BalCCYByCustCode(@Param("customer_code") String customer_code);

    @Select("select distinct Account_Status from LOAN_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code} order by Account_Status")
    @ResultType(String.class)
    List<String> findLoan_AccStatusByCustCode(@Param("customer_code") String customer_code);
}
