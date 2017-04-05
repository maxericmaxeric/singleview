package com.ecsolutions.service;

import com.ecsolutions.entity.PRODUCT_REPAYMENT_DELIQUENCY_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
public interface PRODUCT_REPAYMENT_DELIQUENCY_Service {
    List<PRODUCT_REPAYMENT_DELIQUENCY_Entity> findProductRepaymentDelByCustcdAndCcy(String customer_code, String ccy);

}
