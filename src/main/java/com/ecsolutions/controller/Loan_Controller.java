package com.ecsolutions.controller;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;
import com.ecsolutions.service.Loan_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/22.
 */
@RestController
@RequestMapping("/Loan")
public class Loan_Controller {
    @Autowired
    private Loan_Service loan_service;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoan_Ccy_SumByCustCode")
    public List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> getLoan_Ccy_SumByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity>  deposit_account_type_balance_lcy_sum_entities = loan_service.findLoan_Ccy_SumByCustCode(customer_code);
        return deposit_account_type_balance_lcy_sum_entities;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoan_Type_SumByCustCode_CCY")
    public List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> getLoan_Type_SumByCustCode_CCY(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code, @RequestParam(value="currency", defaultValue = "", required = true) String currency) {
        List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity>  deposit_account_type_balance_lcy_sum_entities = loan_service.findLoan_Type_SumByCustCode_CCY(customer_code, currency);
        return deposit_account_type_balance_lcy_sum_entities;
    }
}
