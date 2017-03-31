package com.ecsolutions.controller;

import com.ecsolutions.entity.DatatableResponse_Entity;
import com.ecsolutions.service.CollateralMain_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@RestController
@RequestMapping("/CollateralMain")
public class CollateralMain_Controller {
    @Autowired
    private CollateralMain_Service collateralMain_service;


    public CollateralMain_Service getCollateralMain_service() {
        return collateralMain_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getCollateralMain")
    public DatatableResponse_Entity getCollateralMain(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code,
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
    @RequestMapping(method = RequestMethod.GET, value = "/getCollateralTypeByCustCode")
    public List<String> getCollateralTypeByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        List<String> ret = this.collateralMain_service.findCollateralTypeByCustCode(customer_code);
        return ret;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getValCurrencyByCustCode")
    public List<String> getValCurrencyByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        List<String> ret = this.collateralMain_service.findValCurrencyByCustCode(customer_code);
        return ret;
    }
}
