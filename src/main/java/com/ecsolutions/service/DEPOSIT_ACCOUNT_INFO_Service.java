package com.ecsolutions.service;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_INFO_Entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
public interface DEPOSIT_ACCOUNT_INFO_Service {
    List<DEPOSIT_ACCOUNT_INFO_Entity> findDEPOSIT_ACCOUNT_INFOByCustomer_code(String customer_code);
    List<String> findDEPOSIT_ACCOUNT_INFO_BranchByCustomer_code(String customer_code);
    List<String> findDEPOSIT_ACCOUNT_INFO_Account_typeByCustomer_code(String customer_code);
    List<String> findDEPOSIT_ACCOUNT_INFO_CurrencyByCustomer_code(String customer_code);
    List<String> findDEPOSIT_ACCOUNT_INFO_Account_statusByCustomer_code(String customer_code);
    List<DEPOSIT_ACCOUNT_INFO_Entity> findDEPOSIT_ACCOUNT_INFOByAll(String customer_code,
                                                                    String[] branch,
                                                                    String dp_account_no,
                                                                    String[] account_type,
                                                                    String[] currency,
                                                                    String open_date_begin,
                                                                    String open_date_end,
                                                                    String maturity_date_begin,
                                                                    String maturity_date_end,
                                                                    BigDecimal account_balance_min,
                                                                    BigDecimal account_balance_max,
                                                                    String[] account_status);


}
