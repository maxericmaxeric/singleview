package com.ecsolutions.service;

import com.ecsolutions.dao.PRODUCT_REPAYMENT_DELIQUENCY_DAO;
import com.ecsolutions.entity.PRODUCT_REPAYMENT_DELIQUENCY_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
@Service("pRODUCT_REPAYMENT_DELIQUENCY_Service")
public class PRODUCT_REPAYMENT_DELIQUENCY_ServiceImpl implements PRODUCT_REPAYMENT_DELIQUENCY_Service{
    private final PRODUCT_REPAYMENT_DELIQUENCY_DAO pRODUCT_REPAYMENT_DELIQUENCY_DAO;
    @Autowired
    public PRODUCT_REPAYMENT_DELIQUENCY_ServiceImpl(PRODUCT_REPAYMENT_DELIQUENCY_DAO pRODUCT_REPAYMENT_DELIQUENCY_DAO) {
        this.pRODUCT_REPAYMENT_DELIQUENCY_DAO = pRODUCT_REPAYMENT_DELIQUENCY_DAO;
    }

    @Override
    public List<PRODUCT_REPAYMENT_DELIQUENCY_Entity> findProductRepaymentDelByCustcdAndCcy(String customer_code, String ccy)
    {
        return pRODUCT_REPAYMENT_DELIQUENCY_DAO.findProductRepaymentDelByCustcdAndCcy(customer_code,ccy);
    }
}
