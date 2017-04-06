package com.ecsolutions.service;

import com.ecsolutions.entity.PRICING_PREFERENTIAL_FEES_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
public interface PRICING_PREFERENTIAL_FEES_Service {
    List<PRICING_PREFERENTIAL_FEES_Entity> findPreferentialFeesByCustd(String customer_code, String search, String orderCol, String orderDir);
    Long findPreferentialFeesTotalByCustd(String customer_code);
}
