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

    // 根据id查询用户
    @Select("SELECT ACCOUNT_TYPE,ROUND(SUM(ACCOUNT_BALANCE_LCY),2) ACCOUNT_BALANCE_LCY_SUM from DEPOSIT_ACCOUNT_INFO WHERE CUSTOMER_CODE = #{customer_code}  GROUP BY ACCOUNT_TYPE")
    @ResultType(DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity.class)
    List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> findDEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUMByCustomer_code(@Param("customer_code") String customer_code);
}
