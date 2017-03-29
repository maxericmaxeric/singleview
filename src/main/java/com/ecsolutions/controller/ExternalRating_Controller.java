package com.ecsolutions.controller;

import com.ecsolutions.entity.ExternalRating_Entity;
import com.ecsolutions.service.ExternalRating_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/29.
 */
@RestController
@RequestMapping("/ExternalRating")
public class ExternalRating_Controller {
    @Autowired
    private ExternalRating_Service externalRating_service;

    public ExternalRating_Service getExternalRating_service() {
        return externalRating_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getExternalRatingByCustCode")
    public ExternalRating_Entity getExternalRatingByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        ExternalRating_Entity customerInfoMain_entity = this.externalRating_service.findExternalRatingByCustCode(customer_code);
        return customerInfoMain_entity;
    }
}
