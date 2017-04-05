package com.ecsolutions.service;

import com.ecsolutions.entity.PRODUCT_LIQUIDITY_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017-4-5.
 */
public interface PRODUCT_LIQUIDITY_Service {
    List<String> findProductLiquidityTenor(String customer_code);
    List<PRODUCT_LIQUIDITY_Entity> findProductLiquidityDepAmt(String customer_code,String ccy);
    List<PRODUCT_LIQUIDITY_Entity> findProductLiquidityLoanAmt(String customer_code,String ccy);
}
