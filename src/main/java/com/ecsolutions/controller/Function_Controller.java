package com.ecsolutions.controller;

import com.ecsolutions.entity.Function_Entity;
import com.ecsolutions.service.Function_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */
@RestController
@RequestMapping("/functions")
public class Function_Controller {
    @Autowired
    private Function_Service function_service;

    public Function_Service getFunction_service() {
        return function_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping
    public List<Function_Entity> get() {
        return function_service.getFunctions();
    }
}
