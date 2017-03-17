package com.ecsolutions.dao;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity;
import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Repository
public interface DEPOSIT_ACCOUNT_TRAN_CURRENCY_DAO {
    //
    @Select("select DISTINCT CURRENCY from DEPOSIT_ACCOUNT_TRAN where customer_code = #{customer_code} ORDER BY CURRENCY")
    @ResultType(DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity.class)
    List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity> findDEPOSIT_ACCOUNT_TRAN_CURRENCYByCustomer_code(@Param("customer_code") String customer_code);

    //
    @Select("SELECT Transaction_Date, sum(Transaction_AMOUNT) transaction_amount from DEPOSIT_ACCOUNT_TRAN where customer_code = #{customer_code} and currency = #{currency} group by Transaction_Date")
    @ResultType(DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity.class)
    List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity> findDEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT(@Param("customer_code") String customer_code, @Param("currency") String currency);

    //
    @Select("SELECT DISTINCT Transaction_Date from DEPOSIT_ACCOUNT_TRAN where customer_code = #{customer_code} order by Transaction_Date")
    @ResultType(String.class)
    List<String> findDEPOSIT_ACCOUNT_TRAN_CURRENCY_TRANSACTION_DATE(@Param("customer_code") String customer_code);



}
