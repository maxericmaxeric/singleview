package com.ecsolutions.service;

import com.ecsolutions.dao.CustomerGroup_DAO;
import com.ecsolutions.entity.CustomerGroup_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@Service("customerGroup_Service")
public class CustomerGroup_ServiceImpl implements CustomerGroup_Service{
    private CustomerGroup_DAO customerGroup_dao;

    @Autowired
    public CustomerGroup_ServiceImpl(CustomerGroup_DAO customerGroup_dao) {
        this.customerGroup_dao = customerGroup_dao;
    }

    @Override
    public List<CustomerGroup_Entity> findCustomerGroupByCustCode(String customer_code) {
        return this.customerGroup_dao.findCustomerGroupByCustCode(customer_code);
    }
}
