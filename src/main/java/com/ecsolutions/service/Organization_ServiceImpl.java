package com.ecsolutions.service;

import com.ecsolutions.dao.Organization_DAO;
import com.ecsolutions.entity.Organization_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
@Service("Organization_Service")
public class Organization_ServiceImpl implements Organization_Service {

    private Organization_DAO organization_dao;

    @Autowired
    public Organization_ServiceImpl(Organization_DAO organization_dao) {
        this.organization_dao = organization_dao;
    }

    @Override
    public List<Organization_Entity> getOrganizations() {
        return organization_dao.getOrganizations();
    }
}
