package com.ecsolutions.service;

import com.ecsolutions.dao.CompanyProfileExtent_DAO;
import com.ecsolutions.entity.CompanyProfileExtent_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/30.
 */
@Service("companyProfileExtent_service")
public class CompanyProfileExtent_ServiceImpl implements CompanyProfileExtent_Service{

    private CompanyProfileExtent_DAO companyProfileExtent_dao;

    @Autowired
    public CompanyProfileExtent_ServiceImpl(CompanyProfileExtent_DAO companyProfileExtent_dao) {
        this.companyProfileExtent_dao = companyProfileExtent_dao;
    }

    @Override
    public CompanyProfileExtent_Entity findCompanyInformationByCustCode(String customer_code) {
        return this.companyProfileExtent_dao.findCompanyInformationByCustCode(customer_code);
    }

    @Override
    public CompanyProfileExtent_Entity findCompanyRegistrationByCustCode(String customer_code) {
        return this.companyProfileExtent_dao.findCompanyRegistrationByCustCode(customer_code);
    }

}
