package com.ecsolutions.dao;

import com.ecsolutions.entity.PRICING_PREFERENTIAL_FX_RATE_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
@Repository
public interface PRICING_PREFERENTIAL_FX_RATE_DAO {
//    @Select("select product_code , product_desc ,CCY1,CCY2,Point, Preminum_Discount from pricing_fx where Customer_Code like concat(concat('%',#{customer_code}),'%')")
    @Select("select product_code , product_desc ,CCY1,CCY2,Point, Preminum_Discount from pricing_fx where Customer_Code = '${customer_code}' ORDER BY ${orderCol}  ${orderDir}")
    @ResultType(PRICING_PREFERENTIAL_FX_RATE_Entity.class)
    List<PRICING_PREFERENTIAL_FX_RATE_Entity> findPreferentialFxRateByCustd(@Param("customer_code") String customer_code, @Param("search") String search, @Param("orderCol") String orderCol, @Param("orderDir") String orderDir);

    @Select("select count(*) from pricing_fx WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(Long.class)
    Long findPreferentialFxTotalByCustd(@Param("customer_code") String customer_code);
}
