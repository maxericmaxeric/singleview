package com.ecsolutions.dao;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
@Repository
public interface DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_DAO {

    // 根据customer_code, currency查询account_type, sum(amount)
    @Select("SELECT ACCOUNT_TYPE TYPE,ROUND(SUM(ACCOUNT_BALANCE_LCY),2) SUM from DEPOSIT_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code} and CURRENCY = #{currency}  GROUP BY ACCOUNT_TYPE")
    @ResultType(DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity.class)
    List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findDEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUMByCustCode_CCY(@Param("customer_code") String customer_code, @Param("currency") String currency);

    // 根据customer_code查询currency, sum(amount)
    @Select("SELECT CURRENCY TYPE,ROUND(SUM(ACCOUNT_BALANCE_LCY),2) SUM from DEPOSIT_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code}  GROUP BY CURRENCY")
    @ResultType(DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity.class)
    List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findDeposit_AccountType_BalanceSumByCustCode(@Param("customer_code") String customer_code);

}
