package com.ecsolutions.service;

import com.ecsolutions.entity.CreditLineMain_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
public interface CreditLineMain_Service {
    Long findCreditLineMain_TotalByCustCode(String customer_code);

    List<CreditLineMain_Entity> findCreditLineMain(String customer_code, String search, String orderCol, String orderDir);

    List<String> findCurrencyByCustCode(String customer_code);

    List<String> findRevolvingIndByCustCode(String customer_code);
}
