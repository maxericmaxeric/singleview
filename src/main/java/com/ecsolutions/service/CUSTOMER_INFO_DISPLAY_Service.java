package com.ecsolutions.service;

import com.ecsolutions.entity.CUSTOMER_INFO_DISPLAY_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017-3-17.
 */
public interface CUSTOMER_INFO_DISPLAY_Service {
    List<CUSTOMER_INFO_DISPLAY_Entity> find_customer_info(String customer_code);

}
