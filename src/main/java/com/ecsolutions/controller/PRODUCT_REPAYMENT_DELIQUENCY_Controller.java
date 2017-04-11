package com.ecsolutions.controller;

import com.ecsolutions.entity.PRODUCT_REPAYMENT_DELIQUENCY_Entity;
import com.ecsolutions.service.PRODUCT_REPAYMENT_DELIQUENCY_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
@RestController
@RequestMapping("/PRODUCT_REPAYMENT_DELIQUENCY")
public class PRODUCT_REPAYMENT_DELIQUENCY_Controller {
    @Autowired
    private PRODUCT_REPAYMENT_DELIQUENCY_Service pRODUCT_REPAYMENT_DELIQUENCY_Service;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getValue")
    public List<PRODUCT_REPAYMENT_DELIQUENCY_Entity> getPRODUCT_REPAYMENT_DELIQUENCY(@RequestParam(value="customer_code", required = true) String customer_code,
                                                       @RequestParam(value="ccy",required = false) String ccy) {
        List<PRODUCT_REPAYMENT_DELIQUENCY_Entity>  product_repayment_deliquency_entities = pRODUCT_REPAYMENT_DELIQUENCY_Service.findProductRepaymentDelByCustcdAndCcy(customer_code,ccy);
        return  product_repayment_deliquency_entities;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getCcy")
    public List<String> getPRODUCT_REPAYMENT_DELIQUENCY_CCY(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        List<String>  product_repayment_deliquency_entities = pRODUCT_REPAYMENT_DELIQUENCY_Service.findProductRepaymentDeliquencyCcy(customer_code);
        return product_repayment_deliquency_entities;
    }
}
