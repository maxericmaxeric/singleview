package com.ecsolutions.service;

import com.ecsolutions.dao.DEPOSIT_ACCOUNT_INFO_DAO;
import com.ecsolutions.entity.DEPOSIT_ACCOUNT_INFO_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
@Service("deposit_account_info_service")
public class DEPOSIT_ACCOUNT_INFO_ServiceImpl implements DEPOSIT_ACCOUNT_INFO_Service {
    private final DEPOSIT_ACCOUNT_INFO_DAO deposit_account_info_dao;

    @Autowired
    public DEPOSIT_ACCOUNT_INFO_ServiceImpl(DEPOSIT_ACCOUNT_INFO_DAO deposit_account_info_dao) {
        this.deposit_account_info_dao = deposit_account_info_dao;
    }
    @Override
    public List<DEPOSIT_ACCOUNT_INFO_Entity> findDEPOSIT_ACCOUNT_INFOByCustomer_code(String customer_code) {
        List<DEPOSIT_ACCOUNT_INFO_Entity> deposit_account_info_entities = this.deposit_account_info_dao.findDEPOSIT_ACCOUNT_INFOByCustomer_code(customer_code);
        return deposit_account_info_entities;
    }

    @Override
    public List<String> findDEPOSIT_ACCOUNT_INFO_BranchByCustomer_code(String customer_code) {
        return this.deposit_account_info_dao.findDEPOSIT_ACCOUNT_INFO_BranchByCustomer_code(customer_code);
    }

    @Override
    public List<String> findDEPOSIT_ACCOUNT_INFO_Account_typeByCustomer_code(String customer_code) {
        return this.deposit_account_info_dao.findDEPOSIT_ACCOUNT_INFO_Account_typeByCustomer_code(customer_code);
    }

    @Override
    public List<String> findDEPOSIT_ACCOUNT_INFO_CurrencyByCustomer_code(String customer_code) {
        return this.deposit_account_info_dao.findDEPOSIT_ACCOUNT_INFO_CurrencyByCustomer_code(customer_code);
    }

    @Override
    public List<String> findDEPOSIT_ACCOUNT_INFO_Account_statusByCustomer_code(String customer_code) {
        return this.deposit_account_info_dao.findDEPOSIT_ACCOUNT_INFO_Account_statusByCustomer_code(customer_code);
    }

    @Override
    public List<DEPOSIT_ACCOUNT_INFO_Entity> findDEPOSIT_ACCOUNT_INFOByAll(String customer_code, String[] branch, String dp_account_no, String[] account_type, String[] currency, String open_date_begin, String open_date_end, String maturity_date_begin, String maturity_date_end, BigDecimal account_balance_min, BigDecimal account_balance_max, String[] account_status) {
        return this.deposit_account_info_dao.findDEPOSIT_ACCOUNT_INFOByAll(customer_code, branch, dp_account_no, account_type,currency,open_date_begin,open_date_end,maturity_date_begin,maturity_date_end,account_balance_min,account_balance_max,account_status);
    }
}
