package com.ecsolutions.service;

import com.ecsolutions.dao.CUSTOMER_INFO_DISPLAY_DAO;
import com.ecsolutions.entity.CUSTOMER_INFO_DISPLAY_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-3-17.
 */
@Service("cUSTOMER_INFO_DISPLAY_Service")
public class CUSTOMER_INFO_DISPLAY_ServiceImpl implements CUSTOMER_INFO_DISPLAY_Service {
    private final CUSTOMER_INFO_DISPLAY_DAO cUSTOMER_INFO_DISPLAY_DAO;

    @Autowired
    public CUSTOMER_INFO_DISPLAY_ServiceImpl(CUSTOMER_INFO_DISPLAY_DAO cUSTOMER_INFO_DISPLAY_DAO) {
        this.cUSTOMER_INFO_DISPLAY_DAO = cUSTOMER_INFO_DISPLAY_DAO;
    }

    @Override
    public List<CUSTOMER_INFO_DISPLAY_Entity> find_customer_info(String customer_code) {
        return cUSTOMER_INFO_DISPLAY_DAO.find_customer_info(customer_code);
    }

}
