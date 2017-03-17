package com.ecsolutions.service;

import com.ecsolutions.entity.DEPOSIT_INFO_SEARCH_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017-3-16.
 */
public interface  DEPOSIT_INFO_SEARCH_Service {
    List<DEPOSIT_INFO_SEARCH_Entity> searchInfoByCustCode(String dp_account_no, String ln_account_no, String customer_code, String customer_full_name, String identity_no);

}
