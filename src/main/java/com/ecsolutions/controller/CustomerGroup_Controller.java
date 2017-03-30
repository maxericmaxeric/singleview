package com.ecsolutions.controller;

import com.ecsolutions.entity.CustomerGroup_Entity;
import com.ecsolutions.service.CustomerGroup_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@RestController
@RequestMapping("/CustomerGroup")
public class CustomerGroup_Controller {
    @Autowired
    private CustomerGroup_Service customerGroup_service;

    public CustomerGroup_Service getCustomerGroup_service() {
        return customerGroup_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getCustomerGroupByCustCode")
    public List<CustomerGroup_Entity> getCustomerGroupByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        List<CustomerGroup_Entity> customerGroup_entities = this.customerGroup_service.findCustomerGroupByCustCode(customer_code);
        return customerGroup_entities;
    }
}
