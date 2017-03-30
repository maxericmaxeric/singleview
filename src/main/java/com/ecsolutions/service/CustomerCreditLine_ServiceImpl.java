package com.ecsolutions.service;

import com.ecsolutions.dao.CustomerCreditLine_dao;
import com.ecsolutions.entity.CustomerCreditLine_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@Service("CustomerCreditLine_Service")
public class CustomerCreditLine_ServiceImpl implements CustomerCreditLine_Service {
    private CustomerCreditLine_dao customerCreditLine_dao;

    @Autowired
    public CustomerCreditLine_ServiceImpl(CustomerCreditLine_dao customerCreditLine_dao) {
        this.customerCreditLine_dao = customerCreditLine_dao;
    }

    @Override
    public List<CustomerCreditLine_Entity> findCustomerCreditLineByCustCode(String customer_code) {
        return this.customerCreditLine_dao.findCustomerCreditLineByCustCode(customer_code);
    }
}
