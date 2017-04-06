package com.ecsolutions.service;

import com.ecsolutions.dao.PRICING_PREFERENTIAL_FX_RATE_DAO;
import com.ecsolutions.entity.PRICING_PREFERENTIAL_FX_RATE_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
@Service("pRICING_PREFERENTIAL_FX_RATE_Service")
public class PRICING_PREFERENTIAL_FX_RATE_ServiceImpl implements PRICING_PREFERENTIAL_FX_RATE_Service{
    private final PRICING_PREFERENTIAL_FX_RATE_DAO pRICING_PREFERENTIAL_FX_RATE_DAO;

    @Autowired
    public PRICING_PREFERENTIAL_FX_RATE_ServiceImpl(PRICING_PREFERENTIAL_FX_RATE_DAO pRICING_PREFERENTIAL_FX_RATE_DAO) {
        this.pRICING_PREFERENTIAL_FX_RATE_DAO = pRICING_PREFERENTIAL_FX_RATE_DAO;
    }

    @Override
    public List<PRICING_PREFERENTIAL_FX_RATE_Entity> findPreferentialFxRateByCustd(String customer_code, String search, String orderCol, String orderDir) {
        return pRICING_PREFERENTIAL_FX_RATE_DAO.findPreferentialFxRateByCustd(customer_code,search,orderCol,orderDir);
    }

    @Override
    public Long findPreferentialFxTotalByCustd(String customer_code)
    {
        return pRICING_PREFERENTIAL_FX_RATE_DAO.findPreferentialFxTotalByCustd(customer_code);
    }
}
