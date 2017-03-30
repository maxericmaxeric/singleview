package com.ecsolutions.service;

import com.ecsolutions.entity.CompanyProfileExtent_Entity;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface CompanyProfileExtent_Service {
    public CompanyProfileExtent_Entity findCompanyInformationByCustCode(String customer_code);

    CompanyProfileExtent_Entity findCompanyRegistrationByCustCode(String customer_code);
}
