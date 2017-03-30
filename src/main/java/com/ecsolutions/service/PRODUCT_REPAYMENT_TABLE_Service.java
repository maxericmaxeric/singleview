package com.ecsolutions.service;

import com.ecsolutions.entity.PRODUCT_REPAYMENT_TABLE_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
public interface PRODUCT_REPAYMENT_TABLE_Service {
    List<PRODUCT_REPAYMENT_TABLE_Entity> findRepaymentDetail(String customer_code,String search, String orderCol, String orderDir);
    Long findDRepaymentTotalCount(String customer_code);
}
