package com.ecsolutions.service;

import com.ecsolutions.dao.PRODUCT_TRANSACTION_DETAIL_DAO;
import com.ecsolutions.entity.PRODUCT_TRANSACTION_DETAIL_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-3-23.
 */
@Service("pRODUCT_TRANSACTION_DETAIL_Service")
public class PRODUCT_TRANSACTION_DETAIL_ServiceImpl implements PRODUCT_TRANSACTION_DETAIL_Service{
    private final PRODUCT_TRANSACTION_DETAIL_DAO pRODUCT_TRANSACTION_DETAIL_DAO;
    @Autowired
    public PRODUCT_TRANSACTION_DETAIL_ServiceImpl(PRODUCT_TRANSACTION_DETAIL_DAO pRODUCT_TRANSACTION_DETAIL_DAO) {
        this.pRODUCT_TRANSACTION_DETAIL_DAO = pRODUCT_TRANSACTION_DETAIL_DAO;
    }

    @Override
    public List<PRODUCT_TRANSACTION_DETAIL_Entity> findTransactionDetailByCustcd(String customer_code, String search, String orderCol, String orderDir)
    {
        return pRODUCT_TRANSACTION_DETAIL_DAO.findTransactionDetailByCustcd(customer_code,search,orderCol,orderDir);
    }
    @Override
    public Long findTransactionDetail_TotalByCustCode(String customer_code)
    {
        return pRODUCT_TRANSACTION_DETAIL_DAO.findTransactionDetail_TotalByCustCode(customer_code);
    }
    @Override
    public List<String> findTransactionBrachByCustCode(String customer_code)
    {
        return pRODUCT_TRANSACTION_DETAIL_DAO.findTransactionBrachByCustCode(customer_code);
    }
    @Override
    public List<String> findTransactionTypeByCustCode(String customer_code)
    {
        return pRODUCT_TRANSACTION_DETAIL_DAO.findTransactionTypeByCustCode(customer_code);
    }
    @Override
    public List<String> findTransactionCcyByCustCode(String customer_code)
    {
        return pRODUCT_TRANSACTION_DETAIL_DAO.findTransactionCcyByCustCode(customer_code);
    }
    @Override
    public List<String> findTransactionDrIndicatorByCustCode(String customer_code)
    {
        return pRODUCT_TRANSACTION_DETAIL_DAO.findTransactionDrIndicatorByCustCode(customer_code);
    }
}
