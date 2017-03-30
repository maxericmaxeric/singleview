package com.ecsolutions.controller;

import com.ecsolutions.entity.CompanyProfileExtent_Entity;
import com.ecsolutions.service.CompanyProfileExtent_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/30.
 */
@RestController
@RequestMapping("/CompanyProfileExtent")
public class CompanyProfileExtent_Controller {
    @Autowired
    private CompanyProfileExtent_Service companyProfileExtent_service;

    public CompanyProfileExtent_Service getCompanyProfileExtent_service() {
        return companyProfileExtent_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getCompanyInformationByCustCode")
    public CompanyProfileExtent_Entity getCompanyInformationByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        CompanyProfileExtent_Entity companyProfileExtent_entity = this.companyProfileExtent_service.findCompanyInformationByCustCode(customer_code);
        return companyProfileExtent_entity;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getCompanyRegistrationByCustCode")
    public CompanyProfileExtent_Entity getCompanyRegistrationByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        CompanyProfileExtent_Entity companyProfileExtent_entity = this.companyProfileExtent_service.findCompanyRegistrationByCustCode(customer_code);
        return companyProfileExtent_entity;
    }
}
