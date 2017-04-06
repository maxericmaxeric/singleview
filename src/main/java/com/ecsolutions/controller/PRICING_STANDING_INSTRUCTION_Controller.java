package com.ecsolutions.controller;

import com.ecsolutions.entity.DatatableResponse_Entity;
import com.ecsolutions.service.PRICING_STANDING_INSTRUCTION_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017-3-27.
 */
@RestController
@RequestMapping("/PRICING_STANDING_INSTRUCTION")
public class PRICING_STANDING_INSTRUCTION_Controller {
    @Autowired
    private PRICING_STANDING_INSTRUCTION_Service pRICING_STANDING_INSTRUCTION_Service;

    public PRICING_STANDING_INSTRUCTION_Service getPricing_Standing_Instruction_Service()
    {
        return pRICING_STANDING_INSTRUCTION_Service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getValue")
    public DatatableResponse_Entity getPRICING_STANDING_INSTRUCTION(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code,
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
