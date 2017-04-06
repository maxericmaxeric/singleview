package com.ecsolutions.dao;

import com.ecsolutions.entity.PRICING_PREFERENTIAL_FEES_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
@Repository
public interface PRICING_PREFERENTIAL_FEES_DAO {
//    @Select("select Fee_Type,Preminum_Discount from pricing_fee where Customer_Code like concat(concat('%',#{customer_code}),'%')")
    @Select("select Fee_Type,Preminum_Discount from pricing_fee where Customer_Code = '${customer_code}' ORDER BY ${orderCol}  ${orderDir}")
    @ResultType(PRICING_PREFERENTIAL_FEES_Entity.class)
    List<PRICING_PREFERENTIAL_FEES_Entity> findPreferentialFeesByCustd(@Param("customer_code") String customer_code, @Param("search") String search, @Param("orderCol") String orderCol, @Param("orderDir") String orderDir);

    @Select("SELECT COUNT(*) FROM pricing_fee WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(Long.class)
    Long findPreferentialFeesTotalByCustd(@Param("customer_code") String customer_code);
}
