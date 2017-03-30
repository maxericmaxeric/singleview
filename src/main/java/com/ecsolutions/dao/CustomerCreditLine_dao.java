package com.ecsolutions.dao;

import com.ecsolutions.entity.CustomerCreditLine_Entity;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@Repository
public interface CustomerCreditLine_dao {
    @Select("SELECT CUSTOMER_CODE AS CODE1, '0' AS PARENTID, CUSTOMER_FULL_NAME AS NAME1, CUSTOMER_FULL_NAME AS DISPLAY, '' AS CURRENCY, -1 AS AVAILABLE_AMOUNT\n" +
            "  FROM CUSTOMER_INFO_MAIN\n" +
            " WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})\n" +
            "UNION\n" +
            "SELECT CREDIT_LINE_NO,\n" +
            "       DECODE(TRIM(PARENT_LINE_NO), NULL, CUSTOMER_CODE, PARENT_LINE_NO),\n" +
            "       LINE_NAME,CREDIT_LINE_NO,CURRENCY,AVAILABLE_AMOUNT\n" +
            "  FROM CREDIT_LINE_MAIN\n" +
            " WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(CustomerCreditLine_Entity.class)
    List<CustomerCreditLine_Entity> findCustomerCreditLineByCustCode(String customer_code);
}
