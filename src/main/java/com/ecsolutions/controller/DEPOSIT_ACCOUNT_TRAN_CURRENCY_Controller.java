package com.ecsolutions.controller;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity;
import com.ecsolutions.service.DEPOSIT_ACCOUNT_TRAN_CURRENCY_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@RestController
@RequestMapping("/DEPOSIT_ACCOUNT_TRAN_CURRENCY")
public class DEPOSIT_ACCOUNT_TRAN_CURRENCY_Controller {
    @Autowired
    private DEPOSIT_ACCOUNT_TRAN_CURRENCY_Service deposit_account_tran_currency_service;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/{customer_code}")
    public List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity> getDEPOSIT_ACCOUNT_TRAN_CURRENCYByCustomer_code(@PathVariable("customer_code") String customer_code) {
        List<DEPOSIT_ACCOUNT_TRAN_CURRENCY_Entity> deposit_account_tran_currency_entities = deposit_account_tran_currency_service.findDEPOSIT_ACCOUNT_TRAN_CURRENCYByCustomer_code(customer_code);
        return deposit_account_tran_currency_entities;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDEPOSIT_ACCOUNT_TRAN_CURRENCY_AllDatesByCustomer_code/{customer_code}")
    public List<String> getDEPOSIT_ACCOUNT_TRAN_CURRENCY_AllDatesByCustomer_code(@PathVariable("customer_code") String customer_code) {
        return this.deposit_account_tran_currency_service.findDEPOSIT_ACCOUNT_TRAN_CURRENCY_TRANSACTION_DATE(customer_code);
    }

}
