package com.ecsolutions.controller;

import com.ecsolutions.entity.Organization_Entity;
import com.ecsolutions.service.Organization_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
@RestController
@RequestMapping("organizations")
public class Organization_Controller {
    @Autowired
    private Organization_Service organization_service;

    public Organization_Service getOrganization_service() {
        return organization_service;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping
    public List<Organization_Entity> getOrganizations() {
        List<Organization_Entity> organization_entities = organization_service.getOrganizations();
        return organization_entities;
    }
}
