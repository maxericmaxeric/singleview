package com.ecsolutions.controller;

import com.ecsolutions.entity.DatatableResponse_Entity;
import com.ecsolutions.service.RelatedParty_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/30.
 */
@RestController
@RequestMapping("/RelatedParty")
public class RelatedParty_Controller {
    @Autowired
    private RelatedParty_Service relatedParty_service;

    public RelatedParty_Service getRelatedParty_service() {
        return relatedParty_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getRelatedParty")
    public DatatableResponse_Entity getRelatedParty(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code,
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
