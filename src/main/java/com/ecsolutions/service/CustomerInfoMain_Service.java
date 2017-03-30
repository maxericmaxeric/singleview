package com.ecsolutions.service;

import com.ecsolutions.entity.CustomerInfoMain_Entity;

/**
 * Created by Administrator on 2017/3/29.
 */
public interface CustomerInfoMain_Service {
    CustomerInfoMain_Entity findCustomerInfoMainByCustCode(String customer_code);

    String findPersonalFlagByCustCode(String customer_code);
}
