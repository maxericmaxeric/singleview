package com.ecsolutions.controller;

import com.ecsolutions.entity.DatatableResponse_Entity;
import com.ecsolutions.service.PRODUCT_TRANSACTION_DETAIL_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
@RestController
@RequestMapping("/PRODUCT_TRANSACTION_DETAIL")
public class PRODUCT_TRANSACTION_DETAIL_Controller {
    @Autowired
    private PRODUCT_TRANSACTION_DETAIL_Service pRODUCT_TRANSACTION_DETAIL_Service;
    public PRODUCT_TRANSACTION_DETAIL_Service getPRODUCT_TRANSACTION_DETAIL_Service() {
        return pRODUCT_TRANSACTION_DETAIL_Service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getValue")
    public DatatableResponse_Entity getPRODUCT_TRANSACTION_DETAIL(@RequestParam(value = "draw", required = true) Integer draw,
                                                                                 @RequestParam(value = "start", required = true) Integer start,
                                                                                 @RequestParam(value = "length", required = true) Integer length,
                                                                                 @RequestParam(value = "orderCol", required = true) String orderCol,
                                                                                 @RequestParam(value = "orderDir", required = true) String orderDir,
                                                                                 @RequestParam(value = "search", required = true) String search,
                                                                                 @RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
//        List<PRODUCT_TRANSACTION_DETAIL_Entity>  product_account_balance_entities = pRODUCT_TRANSACTION_DETAIL_Service.findTransactionDetailByCustcd(customer_code);
//        return  product_account_balance_entities;
        DatatableResponse_Entity datatableResponse_entity = new DatatableResponse_Entity(this, draw,start,length,orderCol,orderDir,search,customer_code);
        return datatableResponse_entity;
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDepTran_Branch/{customer_code}")
    public List<String> getTransactionBrachByCustCode(@PathVariable("customer_code") String customer_code)
    {
        List<String> ret=pRODUCT_TRANSACTION_DETAIL_Service.findTransactionBrachByCustCode(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDepTran_Type/{customer_code}")
    public List<String> getTransactionTypeByCustCode(@PathVariable("customer_code") String customer_code)
    {
        List<String> ret=pRODUCT_TRANSACTION_DETAIL_Service.findTransactionTypeByCustCode(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDepTran_Ccy/{customer_code}")
    public List<String> getTransactionCcyByCustCode(@PathVariable("customer_code") String customer_code)
    {
        List<String> ret=pRODUCT_TRANSACTION_DETAIL_Service.findTransactionCcyByCustCode(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDepTran_Dr_Indicator/{customer_code}")
    public List<String> getTransactionDrIndicatorByCustCode(@PathVariable("customer_code") String customer_code)
    {
        List<String> ret=pRODUCT_TRANSACTION_DETAIL_Service.findTransactionDrIndicatorByCustCode(customer_code);
        return ret;
    }



}
