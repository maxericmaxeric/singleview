package com.ecsolutions.dao;

import com.ecsolutions.entity.CompanyProfileExtent_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/3/30.
 */
@Repository
public interface CompanyProfileExtent_DAO {

    @Select("SELECT  INDUSTRY_CODE_HEAD_OFFICE ,INDUSTRY_CODE_REGULATORY  ,SALES_VOL ,MARKET_SHARE  ,PRODUCT_ARRAY ,REPUTATION  ,NETWORK ,THREATS_CHALLENGES  ,SUCCESS_FACTORS ,POTENTIAL_GAP FROM COMPANY_PROFILE_EXTENT WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(CompanyProfileExtent_Entity.class)
    CompanyProfileExtent_Entity findCompanyInformationByCustCode(@Param("customer_code") String customer_code);

    @Select("SELECT PARENT_SUBSIDIARY_TYPE  ,REGISTRATION_TYPE ,REGISTRATION_NO ,REGISTRATION_DATE ,BUSINESS_LICENSE_EXP_DATE ,ORG_CODE  ,LEGAL_REP ,BUSINESS_AREA ,TAX_NO_NATIONAL ,TAX_NO_LOCAL  ,REGISTERED_CAPITAL  ,LISTED_COMPANY_STATUS ,STOCK_EXCHANGE  ,STOCK_TICKER FROM COMPANY_PROFILE_EXTENT WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(CompanyProfileExtent_Entity.class)
    CompanyProfileExtent_Entity findCompanyRegistrationByCustCode(@Param("customer_code") String customer_code);
}
