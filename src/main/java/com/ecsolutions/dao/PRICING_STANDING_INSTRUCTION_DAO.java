package com.ecsolutions.dao;

import com.ecsolutions.entity.PRICING_STANDING_INSTRUCTION_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
@Repository
public interface PRICING_STANDING_INSTRUCTION_DAO {
//    @Select("select instruction,maker ,SDATE from pricing_si where Customer_Code like concat(concat('%',#{customer_code}),'%')")
    @Select("select instruction,maker ,SDATE from pricing_si where Customer_Code = '${customer_code}' ORDER BY ${orderCol}  ${orderDir}")
    @ResultType(PRICING_STANDING_INSTRUCTION_Entity.class)
    List<PRICING_STANDING_INSTRUCTION_Entity> findStandingInstructionByCustd(@Param("customer_code") String customer_code, @Param("search") String search, @Param("orderCol") String orderCol, @Param("orderDir") String orderDir);

    @Select("select count(*) from pricing_si WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(Long.class)
    Long findSITotalByCustd(@Param("customer_code") String customer_code);

}
