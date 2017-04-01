package com.ecsolutions.service;

import com.ecsolutions.dao.PRODUCT_REPAYMENT_TABLE_DAO;
import com.ecsolutions.entity.PRODUCT_REPAYMENT_TABLE_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
@Service("pRODUCT_REPAYMENT_TABLE_Service")
public class PRODUCT_REPAYMENT_TABLE_ServiceImpl implements PRODUCT_REPAYMENT_TABLE_Service{
    private final PRODUCT_REPAYMENT_TABLE_DAO pRODUCT_REPAYMENT_TABLE_DAO;
    @Autowired
    public PRODUCT_REPAYMENT_TABLE_ServiceImpl(PRODUCT_REPAYMENT_TABLE_DAO pRODUCT_REPAYMENT_TABLE_DAO) {
        this.pRODUCT_REPAYMENT_TABLE_DAO = pRODUCT_REPAYMENT_TABLE_DAO;
    }

    @Override
    public List<PRODUCT_REPAYMENT_TABLE_Entity> findRepaymentDetail(String customer_code,String search, String orderCol, String orderDir)
    {
        return pRODUCT_REPAYMENT_TABLE_DAO.findRepaymentDetail(customer_code,search,orderCol,orderDir);
    }
    @Override
    public Long findDRepaymentTotalCount(String customer_code){
        return pRODUCT_REPAYMENT_TABLE_DAO.findDRepaymentTotalCount(customer_code);
    }
    @Override
    public List<String> findRepaymentBrachByCustCode(String customer_code)
    {
        return pRODUCT_REPAYMENT_TABLE_DAO.findRepaymentBrachByCustCode(customer_code);
    }
    @Override
    public List<String> findRepaymentCcyByCustCode(String customer_code)
    {
        return pRODUCT_REPAYMENT_TABLE_DAO.findRepaymentCcyByCustCode(customer_code);
    }
    @Override
    public List<String> findRepaymentOverdueFlagByCustCode(String customer_code)
    {
        return pRODUCT_REPAYMENT_TABLE_DAO.findRepaymentOverdueFlagByCustCode(customer_code);
    }
}
