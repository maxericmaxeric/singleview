package com.ecsolutions.service;

import com.ecsolutions.dao.DEPOSIT_ACCOUNT_TRAN_CURRENCY_DAO;
import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity;
import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Service("deposit_account_tran_currency_service")
public class DEPOSIT_ACCOUNT_TRAN_CURRENCY_ServiceImpl implements DEPOSIT_ACCOUNT_TRAN_CURRENCY_Service {
    private DEPOSIT_ACCOUNT_TRAN_CURRENCY_DAO deposit_account_tran_currency_dao;

    @Autowired
    public DEPOSIT_ACCOUNT_TRAN_CURRENCY_ServiceImpl(DEPOSIT_ACCOUNT_TRAN_CURRENCY_DAO deposit_account_tran_currency_dao) {
        this.deposit_account_tran_currency_dao = deposit_account_tran_currency_dao;
    }

    @Override
    public List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity> findDEPOSIT_ACCOUNT_TRAN_CURRENCYByCustomer_code(String customer_code) {
        List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity> ret = deposit_account_tran_currency_dao.findDEPOSIT_ACCOUNT_TRAN_CURRENCYByCustomer_code(customer_code);
        List<String> allDateEntities = deposit_account_tran_currency_dao.findDEPOSIT_ACCOUNT_TRAN_CURRENCY_TRANSACTION_DATE(customer_code);

        for (DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity currency_item: ret
             ) {
            List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity> deposit_account_tran_currency_amount_entities = this.deposit_account_tran_currency_dao.findDEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT(customer_code, currency_item.getCurrency());
            List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity> currency_date = new ArrayList<DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity>();
            for (String date: allDateEntities
                 ) {
                BigDecimal amount = new BigDecimal(-1);
                for (DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity deposit_account_tran_currency_amount_entity: deposit_account_tran_currency_amount_entities
                     ) {
                    if (deposit_account_tran_currency_amount_entity.getTransaction_date().equals(date))
                        amount = deposit_account_tran_currency_amount_entity.getTransaction_amount();
                }
                currency_date.add(new DEPOSIT_ACCOUNT_TRAN_CURRENCY_AMOUNT_Entity(date, amount));
            }
            currency_item.setTransaction_amount(currency_date);
        }
        return ret;
    }

    @Override
    public List<String> findDEPOSIT_ACCOUNT_TRAN_CURRENCY_TRANSACTION_DATE(String customer_code) {
        return this.deposit_account_tran_currency_dao.findDEPOSIT_ACCOUNT_TRAN_CURRENCY_TRANSACTION_DATE(customer_code);
    }
}
