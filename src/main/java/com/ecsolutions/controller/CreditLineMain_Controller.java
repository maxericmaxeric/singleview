package com.ecsolutions.controller;

import com.ecsolutions.entity.DatatableResponse_Entity;
import com.ecsolutions.service.CreditLineMain_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@RestController
@RequestMapping("/CreditLineMain")
public class CreditLineMain_Controller {
    @Autowired
    private CreditLineMain_Service creditLineMain_service;

    public CreditLineMain_Service getCreditLineMain_service() {
        return creditLineMain_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getCreditLineMain")
    public DatatableResponse_Entity getCreditLineMain(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code,
                                                    @RequestParam(value = "draw", required = true) Integer draw,
                                                    @RequestParam(value = "start", required = true) Integer start,
                                                    @RequestParam(value = "length", required = true) Integer length,
                                                    @RequestParam(value = "orderCol", required = true) String orderCol,
                                                    @RequestParam(value = "orderDir", required = true) String orderDir,
                                                    @RequestParam(value = "search", required = true) String search) {

        DatatableResponse_Entity datatableResponse_entity = new DatatableResponse_Entity(this, draw,start,length,orderCol.trim(),orderDir.trim(),search,customer_code);
        return datatableResponse_entity;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getCurrencyByCustCode")
    public List<String> getCurrencyByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        List<String> ret = this.creditLineMain_service.findCurrencyByCustCode(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getRevolvingIndByCustCode")
    public List<String> getRevolvingIndByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        List<String> ret = this.creditLineMain_service.findRevolvingIndByCustCode(customer_code);
        return ret;
    }
}
