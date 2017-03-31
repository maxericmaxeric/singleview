package com.ecsolutions.dao;

import com.ecsolutions.dao.sqlProvider.CollateralMain_sqlProvider;
import com.ecsolutions.entity.CollateralMain_Entity;
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
public interface CollateralMain_DAO {
    @Select("SELECT DISTINCT COLLATERAL_TYPE FROM COLLATERAL_MAIN WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(String.class)
    List<String> findCollateralTypeByCustCode(String customer_code);

    @Select("SELECT DISTINCT VAL_CURRENCY FROM COLLATERAL_MAIN WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(String.class)
    List<String> findValCurrencyByCustCode(String customer_code);

    @Select("SELECT COUNT(*) FROM COLLATERAL_MAIN WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(Long.class)
    Long findCollateralMain_TotalByCustCode(String customer_code);

    @SelectProvider(type = CollateralMain_sqlProvider.class, method = "getSql")
    @ResultType(CollateralMain_Entity.class)
    List<CollateralMain_Entity> findCollateralMain(@Param("customer_code") String customer_code,
                                                   @Param("search") String search,
                                                   @Param("orderCol") String orderCol,
                                                   @Param("orderDir") String orderDir);
}
