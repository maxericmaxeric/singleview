package com.ecsolutions.controller;

import com.ecsolutions.entity.CustomerInfoMain_Entity;
import com.ecsolutions.service.CustomerInfoMain_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/29.
 */
@RestController
@RequestMapping("/CustomerInfoMain")
public class CustomerInfoMain_Controller {
    @Autowired
    private CustomerInfoMain_Service customerInfoMain_service;

    public CustomerInfoMain_Service getCustomerInfoMain_service() {
        return customerInfoMain_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getCustomerInfoMainByCustCode")
    public CustomerInfoMain_Entity getCustomerInfoMainByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        CustomerInfoMain_Entity customerInfoMain_entity = this.customerInfoMain_service.findCustomerInfoMainByCustCode(customer_code);
        return customerInfoMain_entity;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getPersonalFlagByCustCode")
    public String getPersonalFlagByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        String  ret = this.customerInfoMain_service.findPersonalFlagByCustCode(customer_code);
        return ret;
    }


}
