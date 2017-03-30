package com.ecsolutions.controller;

import com.ecsolutions.entity.DatatableResponse_Entity;
import com.ecsolutions.service.BackgroundCheck_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/30.
 */
@RestController
@RequestMapping("/BackgroundCheck")
public class BackgroundCheck_Controller {
    @Autowired
    private BackgroundCheck_Service backgroundCheck_service;

    public BackgroundCheck_Service getBackgroundCheck_service() {
        return backgroundCheck_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getBackgroundCheck")
    public DatatableResponse_Entity getBackgroundCheck(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code,
                                                       @RequestParam(value = "draw", required = true) Integer draw,
                                                       @RequestParam(value = "start", required = true) Integer start,
                                                       @RequestParam(value = "length", required = true) Integer length,
                                                       @RequestParam(value = "orderCol", required = true) String orderCol,
                                                       @RequestParam(value = "orderDir", required = true) String orderDir,
                                                       @RequestParam(value = "search", required = true) String search) {

        DatatableResponse_Entity datatableResponse_entity = new DatatableResponse_Entity(this, draw,start,length,orderCol.trim(),orderDir.trim(),search,customer_code);
        return datatableResponse_entity;
    }
}
