package com.ecsolutions.controller;

import com.ecsolutions.service.PRODUCT_REPAYMENT_TIMEOVERDUE_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017-3-23.
 */
@RestController
@RequestMapping("/PRODUCT_REPAYMENT_TIMEOVERDUE")
public class PRODUCT_REPAYMENT_TIMEOVERDUE_Controller {
    @Autowired
    private PRODUCT_REPAYMENT_TIMEOVERDUE_Service  pRODUCT_REPAYMENT_TIMEOVERDUE_Service;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getValue")
    public int getPRODUCT_REPAYMENT_TIMEOVERDUE() {
        int  count =pRODUCT_REPAYMENT_TIMEOVERDUE_Service.findProductRepaymentTimeoverdueCount();
        return count;
    }
}
