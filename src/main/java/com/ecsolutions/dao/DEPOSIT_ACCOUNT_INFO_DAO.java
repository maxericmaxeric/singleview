package com.ecsolutions.dao;

import com.ecsolutions.dao.sqlProvider.DEPOSIT_ACCOUNT_INFO_sqlProvider;
import com.ecsolutions.entity.DEPOSIT_ACCOUNT_INFO_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
@Repository
public interface DEPOSIT_ACCOUNT_INFO_DAO {
    //
    @Select("select BRANCH,DP_ACCOUNT_NO,ACCOUNT_TYPE,CURRENCY,OPEN_DATE,MATURITY_DATE,ACCOUNT_BALANCE,ACCOUNT_STATUS from DEPOSIT_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code}")
    @ResultType(DEPOSIT_ACCOUNT_INFO_Entity.class)
    List<DEPOSIT_ACCOUNT_INFO_Entity> findDEPOSIT_ACCOUNT_INFOByCustomer_code(@Param("customer_code") String customer_code);

    @Select("select distinct BRANCH from DEPOSIT_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code} order by BRANCH")
    @ResultType(String.class)
    List<String> findDEPOSIT_ACCOUNT_INFO_BranchByCustomer_code(@Param("customer_code") String customer_code);

    @Select("select distinct ACCOUNT_TYPE from DEPOSIT_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code} order by ACCOUNT_TYPE")
    @ResultType(String.class)
    List<String> findDEPOSIT_ACCOUNT_INFO_Account_typeByCustomer_code(@Param("customer_code") String customer_code);

    @Select("select distinct CURRENCY from DEPOSIT_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code} order by CURRENCY")
    @ResultType(String.class)
    List<String> findDEPOSIT_ACCOUNT_INFO_CurrencyByCustomer_code(@Param("customer_code") String customer_code);

    @Select("select distinct ACCOUNT_STATUS from DEPOSIT_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code} order by ACCOUNT_STATUS")
    @ResultType(String.class)
    List<String> findDEPOSIT_ACCOUNT_INFO_Account_statusByCustomer_code(@Param("customer_code") String customer_code);

    @SelectProvider(type = DEPOSIT_ACCOUNT_INFO_sqlProvider.class, method = "getDEPOSIT_ACCOUNT_INFO_Sql")
    @ResultType(DEPOSIT_ACCOUNT_INFO_Entity.class)
    List<DEPOSIT_ACCOUNT_INFO_Entity> findDEPOSIT_ACCOUNT_INFOByAll(@Param("customer_code") String customer_code,
                                                                    @Param("branch") String[] branch,
                                                                    @Param("dp_account_no") String dp_account_no,
                                                                    @Param("account_type") String[] account_type,
                                                                    @Param("currency") String[] currency,
                                                                    @Param("open_date_begin") String open_date_begin,
                                                                    @Param("open_date_end") String open_date_end,
                                                                    @Param("maturity_date_begin") String maturity_date_begin,
                                                                    @Param("maturity_date_end") String maturity_date_end,
                                                                    @Param("account_balance_min") BigDecimal account_balance_min,
                                                                    @Param("account_balance_max") BigDecimal account_balance_max,
                                                                    @Param("account_status") String[] account_status);
 /*   @Param("customer_code") String customer_code,
    @Param("branch") String branch,
    @Param("dp_account_no") String dp_account_no,
    @Param("account_type") String account_type,
    @Param("currency") String currency,
    @Param("open_date_begin") String open_date_begin,
    @Param("open_date_end") String open_date_end,
    @Param("maturity_date_begin") String maturity_date_begin,
    @Param("maturity_date_end") String maturity_date_end,
    @Param("account_balance") BigDecimal account_balance,
    @Param("account_status") String account_status*/

  /*  String customer_code,
    String branch,
    String dp_account_no,
    String account_type,
    String currency,
    String open_date_begin,
    String open_date_end,
    String maturity_date_begin,
    String maturity_date_end,
    BigDecimal account_balance,
    String account_status)*/

}
