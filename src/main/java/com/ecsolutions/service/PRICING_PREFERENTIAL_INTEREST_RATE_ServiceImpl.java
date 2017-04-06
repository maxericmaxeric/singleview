package com.ecsolutions.service;

import com.ecsolutions.dao.PRICING_PREFERENTIAL_INTEREST_RATE_DAO;
import com.ecsolutions.entity.PRICING_PREFERENTIAL_INTEREST_RATE_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
@Service("pRICING_PREFERENTIAL_INTEREST_RATE_Service")
public class PRICING_PREFERENTIAL_INTEREST_RATE_ServiceImpl implements PRICING_PREFERENTIAL_INTEREST_RATE_Service{
    private final PRICING_PREFERENTIAL_INTEREST_RATE_DAO pRICING_PREFERENTIAL_INTEREST_RATE_DAO;

    @Autowired
    public PRICING_PREFERENTIAL_INTEREST_RATE_ServiceImpl(PRICING_PREFERENTIAL_INTEREST_RATE_DAO pRICING_PREFERENTIAL_INTEREST_RATE_DAO) {
        this.pRICING_PREFERENTIAL_INTEREST_RATE_DAO = pRICING_PREFERENTIAL_INTEREST_RATE_DAO;
    }

    @Override
    public List<PRICING_PREFERENTIAL_INTEREST_RATE_Entity> findPreferentialInterestRateByCustd(String customer_code, String search, String orderCol, String orderDir) {
        return pRICING_PREFERENTIAL_INTEREST_RATE_DAO.findPreferentialInterestRateByCustd(customer_code,search,orderCol,orderDir);
    }

    @Override
    public Long  findPreferentialIRTotalByCustd(String customer_code)
    {
        return pRICING_PREFERENTIAL_INTEREST_RATE_DAO.findPreferentialIRTotalByCustd(customer_code);
    }
}
