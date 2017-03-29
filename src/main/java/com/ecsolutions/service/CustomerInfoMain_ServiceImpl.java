package com.ecsolutions.service;

import com.ecsolutions.dao.CustomerInfoMain_DAO;
import com.ecsolutions.entity.CustomerInfoMain_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/29.
 */
@Service("customerInfoMain_service")
public class CustomerInfoMain_ServiceImpl implements  CustomerInfoMain_Service{
    private final CustomerInfoMain_DAO customerInfoMain_dao;

    @Autowired
    public CustomerInfoMain_ServiceImpl(CustomerInfoMain_DAO customerInfoMain_dao) {
        this.customerInfoMain_dao = customerInfoMain_dao;
    }

    @Override
    public CustomerInfoMain_Entity findCustomerInfoMainByCustCode(String customer_code) {
        return customerInfoMain_dao.findCustomerInfoMainByCustCode(customer_code);
    }
}
