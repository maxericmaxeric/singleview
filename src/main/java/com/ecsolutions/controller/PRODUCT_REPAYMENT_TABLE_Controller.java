package com.ecsolutions.controller;

import com.ecsolutions.entity.DatatableResponse_Entity;
import com.ecsolutions.service.PRODUCT_REPAYMENT_TABLE_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017-3-23.
 */
@RestController
@RequestMapping("/PRODUCT_REPAYMENT_TABLE")
public class PRODUCT_REPAYMENT_TABLE_Controller {
    @Autowired
    private PRODUCT_REPAYMENT_TABLE_Service pRODUCT_REPAYMENT_TABLE_Service;
    public PRODUCT_REPAYMENT_TABLE_Service getPRODUCT_REPAYMENT_TABLE_Service() {
        return pRODUCT_REPAYMENT_TABLE_Service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getValue")
    public DatatableResponse_Entity getPRODUCT_REPAYMENT_TABLE(@RequestParam(value = "draw", required = true) Integer draw,
                                                                           @RequestParam(value = "start", required = true) Integer start,
                                                                           @RequestParam(value = "length", required = true) Integer length,
                                                                           @RequestParam(value = "orderCol", required = true) String orderCol,
                                                                           @RequestParam(value = "orderDir", required = true) String orderDir,
                                                                           @RequestParam(value = "search", required = true) String search,
                                                                           @RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
//        List<PRODUCT_REPAYMENT_TABLE_Entity>  product_repayment_table_entities = pRODUCT_REPAYMENT_TABLE_Service.findRepaymentTable();
//        return product_repayment_table_entities;
        DatatableResponse_Entity datatableResponse_entity = new DatatableResponse_Entity(this, draw,start,length,orderCol,orderDir,search,customer_code);
        return datatableResponse_entity;
    }
}
