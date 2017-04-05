package com.ecsolutions.controller;

import com.ecsolutions.entity.PRODUCT_LIQUIDITY_Entity;
import com.ecsolutions.service.PRODUCT_LIQUIDITY_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017-4-5.
 */
@RestController
@RequestMapping("/PRODUCT_LIQUIDITY")
public class PRODUCT_LIQUIDITY_Controller {
    @Autowired
    private PRODUCT_LIQUIDITY_Service pRODUCT_LIQUIDITY_Service;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getTenor")
    public List<String> getPRODUCT_LIQUIDITY_TENOR(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        List<String>  product_liquidity_tenor_entities = pRODUCT_LIQUIDITY_Service.findProductLiquidityTenor(customer_code);
        return product_liquidity_tenor_entities;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getDepAmt")
    public List<PRODUCT_LIQUIDITY_Entity> getPRODUCT_LIQUIDITY_DEPAMT(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code,
                                                                      @RequestParam(value="ccy",defaultValue = "",required = true) String ccy) {
        List<PRODUCT_LIQUIDITY_Entity>  product_liquidity_depamt_entities = pRODUCT_LIQUIDITY_Service.findProductLiquidityDepAmt(customer_code,ccy);
        return product_liquidity_depamt_entities;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getLoanAmt")
    public List<PRODUCT_LIQUIDITY_Entity> getPRODUCT_LIQUIDITY_LOANAMT(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code,
                                                                      @RequestParam(value="ccy",defaultValue = "",required = true) String ccy) {
        List<PRODUCT_LIQUIDITY_Entity>  product_liquidity_loanamt_entities = pRODUCT_LIQUIDITY_Service.findProductLiquidityLoanAmt(customer_code,ccy);
        return product_liquidity_loanamt_entities;
    }

}
