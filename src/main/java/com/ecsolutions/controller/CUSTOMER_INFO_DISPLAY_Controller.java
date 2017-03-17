package com.ecsolutions.controller;

import com.ecsolutions.entity.CUSTOMER_INFO_DISPLAY_Entity;
import com.ecsolutions.service.CUSTOMER_INFO_DISPLAY_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017-3-17.
 */
@RestController
@RequestMapping("/CUSTOMER_INFO_DISPLAY")
public class CUSTOMER_INFO_DISPLAY_Controller {
    @Autowired
    private CUSTOMER_INFO_DISPLAY_Service cUSTOMER_INFO_DISPLAY_Service;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/{customer_code}")
    public List<CUSTOMER_INFO_DISPLAY_Entity> getFind_customer_info(@PathVariable("customer_code") String customer_code) {
        List<CUSTOMER_INFO_DISPLAY_Entity> cUSTOMER_INFO_DISPLAY_Entity = cUSTOMER_INFO_DISPLAY_Service.find_customer_info(customer_code);
        return cUSTOMER_INFO_DISPLAY_Entity;
    }
}
