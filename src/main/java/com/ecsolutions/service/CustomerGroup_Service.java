package com.ecsolutions.service;

import com.ecsolutions.entity.CustomerGroup_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface CustomerGroup_Service {
    List<CustomerGroup_Entity> findCustomerGroupByCustCode(String customer_code);
}
