package com.ecsolutions.service;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
public interface DEPOSIT_ACCOUNT_TRAN_CURRENCY_Service {
    List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity> findDEPOSIT_ACCOUNT_TRAN_CURRENCYByCustomer_code(String customer_code);
    List<String> findDEPOSIT_ACCOUNT_TRAN_CURRENCY_TRANSACTION_DATE(String customer_code);
  }
