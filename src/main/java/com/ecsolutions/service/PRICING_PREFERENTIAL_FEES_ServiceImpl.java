package com.ecsolutions.service;

import com.ecsolutions.dao.PRICING_PREFERENTIAL_FEES_DAO;
import com.ecsolutions.entity.PRICING_PREFERENTIAL_FEES_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
@Service("pRICING_PREFERENTIAL_FEES_Service")
public class PRICING_PREFERENTIAL_FEES_ServiceImpl implements PRICING_PREFERENTIAL_FEES_Service{
    private final PRICING_PREFERENTIAL_FEES_DAO pRICING_PREFERENTIAL_FEES_DAO;

    @Autowired
    public PRICING_PREFERENTIAL_FEES_ServiceImpl(PRICING_PREFERENTIAL_FEES_DAO pRICING_PREFERENTIAL_FEES_DAO) {
        this.pRICING_PREFERENTIAL_FEES_DAO = pRICING_PREFERENTIAL_FEES_DAO;
    }

    @Override
    public List<PRICING_PREFERENTIAL_FEES_Entity> findPreferentialFeesByCustd(String customer_code, String search, String orderCol, String orderDir) {
        return pRICING_PREFERENTIAL_FEES_DAO.findPreferentialFeesByCustd(customer_code,search,orderCol,orderDir);
    }

    @Override
    public Long findPreferentialFeesTotalByCustd(String customer_code)
    {
        return pRICING_PREFERENTIAL_FEES_DAO.findPreferentialFeesTotalByCustd(customer_code);
    }
}
