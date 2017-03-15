package com.ecsolutions.controller;

import com.ecsolutions.entity.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity;
import com.ecsolutions.service.DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
@RestController
@RequestMapping("/DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM")
public class DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Controller {
    @Autowired
    private DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Service dEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Service;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/{customer_code}")
    public List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> getDEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUMByCustomer_code(@PathVariable("customer_code") String customer_code) {
        List<DEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entity> dEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entitys = dEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Service.findDEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUMByCustomer_code(customer_code);
        return dEPOSIT_ACCOUNT_TYPE_BALANCE_LCY_SUM_Entitys;
    }
}
