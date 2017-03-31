package com.ecsolutions.controller;

import com.ecsolutions.entity.CallMemo_Entity;
import com.ecsolutions.service.CallMemo_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@RestController
@RequestMapping("/CallMemo")
public class CallMemo_Controller {
    @Autowired
    private CallMemo_Service callMemo_service;

    public CallMemo_Service getCallMemo_service() {
        return callMemo_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, value = "/getCallMemoByCustCode")
    public List<CallMemo_Entity> getCallMemoByCustCode(@RequestParam(value="customer_code", defaultValue = "", required = true) String customer_code) {
        List<CallMemo_Entity> ret = this.callMemo_service.findCallMemoByCustCode(customer_code);
        return ret;
    }
}
