package com.ecsolutions.dao;

import com.ecsolutions.entity.CustomerInfoMain_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/3/29.
 */
@Repository
public interface CustomerInfoMain_DAO {
    @Select("SELECT BRANCH,CUSTOMER_CODE,CUSTOMER_FULL_NAME,CUSTOMER_SHORT_NAME,IDENTITY_NO,CUSTOMER_STATUS,CLOSE_DATE,OPEN_DATE,TEL_NO,FAX_NO,EMAIL_ADDRESS,RELATIONSHIP_LEVEL,CREDIT_RATING,CUSTOMER_TYPE,COUNTRY_CODE,PARENT_CUSTOMER_CODE,START_DATE FROM CUSTOMER_INFO_MAIN WHERE CUSTOMER_CODE = #{customer_code}")
    @ResultType(CustomerInfoMain_Entity.class)
    CustomerInfoMain_Entity findCustomerInfoMainByCustCode(@Param("customer_code") String customer_code);

    @Select("SELECT PERSONAL_FLAG FROM CUSTOMER_INFO_MAIN WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(String.class)
    String findPersonalFlagByCustCode(@Param("customer_code") String customer_code);
}
