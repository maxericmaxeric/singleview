package com.ecsolutions.service;

import com.ecsolutions.entity.PRODUCT_TRANSACTION_DETAIL_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
public interface PRODUCT_TRANSACTION_DETAIL_Service {
    List<PRODUCT_TRANSACTION_DETAIL_Entity> findTransactionDetailByCustcd(String customer_code, String search, String orderCol, String orderDir);
    Long findTransactionDetail_TotalByCustCode(String customer_code);
    List<String> findTransactionBrachByCustCode(String customer_code);
    List<String> findTransactionTypeByCustCode(String customer_code);
    List<String> findTransactionCcyByCustCode(String customer_code);
    List<String> findTransactionDrIndicatorByCustCode(String customer_code);
}
