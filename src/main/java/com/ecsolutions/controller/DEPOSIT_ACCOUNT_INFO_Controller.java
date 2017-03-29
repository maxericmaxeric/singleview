package com.ecsolutions.controller;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_INFO_Entity;
import com.ecsolutions.entity.DatatableResponse_Entity;
import com.ecsolutions.service.DEPOSIT_ACCOUNT_INFO_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
@RestController
@RequestMapping("/DEPOSIT_ACCOUNT_INFO")
public class DEPOSIT_ACCOUNT_INFO_Controller {

    @Autowired
    private DEPOSIT_ACCOUNT_INFO_Service deposit_account_info_service;


    public DEPOSIT_ACCOUNT_INFO_Service getDeposit_account_info_service() {
        return deposit_account_info_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/{customer_code}")
    public List<DEPOSIT_ACCOUNT_INFO_Entity>  getDEPOSIT_ACCOUNT_INFOByCustomer_code(@PathVariable("customer_code") String customer_code) {
        List<DEPOSIT_ACCOUNT_INFO_Entity> deposit_account_info_entities = deposit_account_info_service.findDEPOSIT_ACCOUNT_INFOByCustomer_code(customer_code);
        return deposit_account_info_entities;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDEPOSIT_ACCOUNT_INFO_Branch/{customer_code}")
    public List<String> getDEPOSIT_ACCOUNT_INFO_BranchByCustomer_code(@PathVariable("customer_code") String customer_code) {
        List<String> ret = deposit_account_info_service.findDEPOSIT_ACCOUNT_INFO_BranchByCustomer_code(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDEPOSIT_ACCOUNT_INFO_Account_type/{customer_code}")
    public List<String> getDEPOSIT_ACCOUNT_INFO_Account_typeByCustomer_code(@PathVariable("customer_code") String customer_code) {
        List<String> ret = deposit_account_info_service.findDEPOSIT_ACCOUNT_INFO_Account_typeByCustomer_code(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDEPOSIT_ACCOUNT_INFO_Currency/{customer_code}")
    public List<String> getDEPOSIT_ACCOUNT_INFO_CurrencyByCustomer_code(@PathVariable("customer_code") String customer_code) {
        List<String> ret = deposit_account_info_service.findDEPOSIT_ACCOUNT_INFO_CurrencyByCustomer_code(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDEPOSIT_ACCOUNT_INFO_Account_status/{customer_code}")
    public List<String> getDEPOSIT_ACCOUNT_INFO_Account_statusByCustomer_code(@PathVariable("customer_code") String customer_code) {
        List<String> ret = deposit_account_info_service.findDEPOSIT_ACCOUNT_INFO_Account_statusByCustomer_code(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDEPOSIT_ACCOUNT_INFO_ByAll")
    public List<DEPOSIT_ACCOUNT_INFO_Entity> findDEPOSIT_ACCOUNT_INFOByAll(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code,
                                                                    @RequestParam(value="branch", defaultValue = "", required = false) String[] branch,
                                                                    @RequestParam(value="dp_account_no", defaultValue = "", required = false) String dp_account_no,
                                                                    @RequestParam(value="account_type", defaultValue = "", required = false) String[] account_type,
                                                                    @RequestParam(value="currency", defaultValue = "", required = false) String[] currency,
                                                                    @RequestParam(value="open_date_begin", defaultValue = "", required = false) String open_date_begin,
                                                                    @RequestParam(value="open_date_end", defaultValue = "", required = false) String open_date_end,
                                                                    @RequestParam(value="maturity_date_begin", defaultValue = "", required = false) String maturity_date_begin,
                                                                    @RequestParam(value="maturity_date_end", defaultValue = "", required = false) String maturity_date_end,
                                                                    @RequestParam(value="account_balance_min", defaultValue = "-1", required = false) BigDecimal account_balance_min,
                                                                    @RequestParam(value="account_balance_max", defaultValue = "-1", required = false) BigDecimal account_balance_max,
                                                                    @RequestParam(value="account_status", defaultValue = "", required = false) String[] account_status) {
        return this.deposit_account_info_service.findDEPOSIT_ACCOUNT_INFOByAll(customer_code,branch,dp_account_no,account_type,currency,open_date_begin,open_date_end,maturity_date_begin,maturity_date_end, account_balance_min, account_balance_max, account_status);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDeposit")
    public DatatableResponse_Entity getDeposit(@RequestParam(value = "draw", required = true) Integer draw,
                                                @RequestParam(value = "start", required = true) Integer start,
                                                @RequestParam(value = "length", required = true) Integer length,
                                                @RequestParam(value = "orderCol", required = true) String orderCol,
                                                @RequestParam(value = "orderDir", required = true) String orderDir,
                                                @RequestParam(value = "search", required = true) String search,
                                                @RequestParam(value = "customer_code", required = true) String customer_code) {
        DatatableResponse_Entity datatableResponse_entity = new DatatableResponse_Entity(this, draw,start,length,orderCol,orderDir,search,customer_code);
        return datatableResponse_entity;
    }


}
