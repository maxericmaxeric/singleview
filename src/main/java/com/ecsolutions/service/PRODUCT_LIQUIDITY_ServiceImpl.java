package com.ecsolutions.service;

import com.ecsolutions.dao.PRODUCT_LIQUIDITY_DAO;
import com.ecsolutions.entity.PRODUCT_LIQUIDITY_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-4-5.
 */
@Service("pRODUCT_LIQUIDITY_Service")
public class PRODUCT_LIQUIDITY_ServiceImpl implements PRODUCT_LIQUIDITY_Service{
    private final PRODUCT_LIQUIDITY_DAO pRODUCT_LIQUIDITY_DAO;
    @Autowired
    public PRODUCT_LIQUIDITY_ServiceImpl(PRODUCT_LIQUIDITY_DAO pRODUCT_LIQUIDITY_DAO) {
        this.pRODUCT_LIQUIDITY_DAO = pRODUCT_LIQUIDITY_DAO;
    }

    @Override
    public List<String> findProductLiquidityTenor(String customer_code)
    {
        return pRODUCT_LIQUIDITY_DAO.findProductLiquidityTenor(customer_code);
    }

    @Override
    public List<String> findProductLiquidityCcy(String customer_code)
    {
        return pRODUCT_LIQUIDITY_DAO.findProductLiquidityCcy(customer_code);
    }

    @Override
    public List<PRODUCT_LIQUIDITY_Entity> findProductLiquidityDepAmt(String customer_code, String ccy)
    {
        return pRODUCT_LIQUIDITY_DAO.findProductLiquidityDepAmt(customer_code,ccy);
    }

    @Override
    public List<PRODUCT_LIQUIDITY_Entity> findProductLiquidityLoanAmt(String customer_code,String ccy)
    {
        return pRODUCT_LIQUIDITY_DAO.findProductLiquidityLoanAmt(customer_code,ccy);
    }
}
