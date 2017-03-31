package com.ecsolutions.service;

import com.ecsolutions.entity.CollateralMain_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
public interface CollateralMain_Service {
    List<String> findCollateralTypeByCustCode(String customer_code);

    List<String> findValCurrencyByCustCode(String customer_code);

    Long findCollateralMain_TotalByCustCode(String customer_code);

    List<CollateralMain_Entity> findCollateralMain(String customer_code, String search, String orderCol, String orderDir);
}
