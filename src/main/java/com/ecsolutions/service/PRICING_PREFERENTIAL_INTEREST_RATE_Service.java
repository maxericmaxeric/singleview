package com.ecsolutions.service;

import com.ecsolutions.entity.PRICING_PREFERENTIAL_INTEREST_RATE_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
public interface PRICING_PREFERENTIAL_INTEREST_RATE_Service {
    List<PRICING_PREFERENTIAL_INTEREST_RATE_Entity> findPreferentialInterestRateByCustd(String customer_code, String search, String orderCol, String orderDir);
    Long  findPreferentialIRTotalByCustd(String customer_code);

}
