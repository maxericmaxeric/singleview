package com.ecsolutions.dao;

import com.ecsolutions.dao.sqlProvider.CreditLineMain_sqlProvider;
import com.ecsolutions.entity.CreditLineMain_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@Repository
public interface CreditLineMain_DAO {
    @Select("SELECT COUNT(*) FROM CREDIT_LINE_MAIN WHERE CUSTOMER_CODE = #{customer_code}")
    @ResultType(Long.class)
    Long findCreditLineMain_TotalByCustCode(String customer_code);

    @SelectProvider(type = CreditLineMain_sqlProvider.class, method = "getSql")
    @ResultType(CreditLineMain_Entity.class)
    List<CreditLineMain_Entity> findCreditLineMain(@Param("customer_code") String customer_code,
                                                   @Param("search") String search,
                                                   @Param("orderCol") String orderCol,
                                                   @Param("orderDir") String orderDir);

    @Select("SELECT DISTINCT CURRENCY FROM CREDIT_LINE_MAIN WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(String.class)
    List<String> findCurrencyByCustCode(String customer_code);

    @Select("SELECT DISTINCT REVOLVING_IND FROM CREDIT_LINE_MAIN WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(String.class)
    List<String> findRevolvingIndByCustCode(String customer_code);
}
