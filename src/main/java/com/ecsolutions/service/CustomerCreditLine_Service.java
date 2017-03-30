package com.ecsolutions.service;

import com.ecsolutions.entity.CustomerCreditLine_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface CustomerCreditLine_Service {
    List<CustomerCreditLine_Entity> findCustomerCreditLineByCustCode(String customer_code);
}
