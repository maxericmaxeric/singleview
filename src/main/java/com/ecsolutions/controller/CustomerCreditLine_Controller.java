package com.ecsolutions.controller;

import com.ecsolutions.entity.CustomerCreditLine_Entity;
import com.ecsolutions.service.CustomerCreditLine_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@RestController
@RequestMapping("/CustomerCreditLine")
public class CustomerCreditLine_Controller {
    @Autowired
    private CustomerCreditLine_Service customerCreditLine_service;

    public CustomerCreditLine_Service getCustomerCreditLine_service() {
        return customerCreditLine_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getCustomerCreditLineByCustCode")
    public List<CustomerCreditLine_Entity> getCustomerCreditLineByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        List<CustomerCreditLine_Entity> customerCreditLine_entities = this.customerCreditLine_service.findCustomerCreditLineByCustCode(customer_code);
        return customerCreditLine_entities;
    }
}
