package com.ecsolutions.service;

import com.ecsolutions.dao.PRODUCT_REPAYMENT_TIMEOVERDUE_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-3-23.
 */
@Service("pRODUCT_REPAYMENT_TIMEOVERDUE_Service")
public class PRODUCT_REPAYMENT_TIMEOVERDUE_ServiceImpl implements PRODUCT_REPAYMENT_TIMEOVERDUE_Service{
    private final PRODUCT_REPAYMENT_TIMEOVERDUE_DAO pRODUCT_REPAYMENT_TIMEOVERDUE_DAO;
    @Autowired
    public PRODUCT_REPAYMENT_TIMEOVERDUE_ServiceImpl(PRODUCT_REPAYMENT_TIMEOVERDUE_DAO pRODUCT_REPAYMENT_TIMEOVERDUE_DAO) {
        this.pRODUCT_REPAYMENT_TIMEOVERDUE_DAO = pRODUCT_REPAYMENT_TIMEOVERDUE_DAO;
    }

    @Override
    public int findProductRepaymentTimeoverdueCount()
    {
        return pRODUCT_REPAYMENT_TIMEOVERDUE_DAO.findProductRepaymentTimeoverdueCount();
    }

}
