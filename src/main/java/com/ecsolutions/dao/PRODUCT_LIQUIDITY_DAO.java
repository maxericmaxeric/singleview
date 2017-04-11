package com.ecsolutions.dao;

import com.ecsolutions.entity.PRODUCT_LIQUIDITY_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-4-5.
 */
@Repository
public interface PRODUCT_LIQUIDITY_DAO {
    @Select("select  distinct TENOR from liquidity_for_graph where customer_code='${customer_code}'")
    @ResultType(String.class)
    List<String> findProductLiquidityTenor(@Param("customer_code") String customer_code);

    @Select("select  distinct ccy from liquidity_for_graph where customer_code='${customer_code}'")
    @ResultType(String.class)
    List<String> findProductLiquidityCcy(@Param("customer_code") String customer_code);

    @Select("select a.tenor tenor,sum(a.amount) amount from liquidity_for_graph a where MARK ='DEP' and customer_code='${customer_code}' and ccy='${ccy}' group by a.tenor")
    @ResultType(PRODUCT_LIQUIDITY_Entity.class)
    List<PRODUCT_LIQUIDITY_Entity> findProductLiquidityDepAmt(@Param("customer_code") String customer_code,@Param("ccy") String ccy);

    @Select("select a.tenor tenor,sum(a.amount) amount from liquidity_for_graph a where MARK ='LN' and customer_code='${customer_code}' and ccy='${ccy}' group by a.tenor")
    @ResultType(PRODUCT_LIQUIDITY_Entity.class)
    List<PRODUCT_LIQUIDITY_Entity> findProductLiquidityLoanAmt(@Param("customer_code") String customer_code,@Param("ccy") String ccy);

}
