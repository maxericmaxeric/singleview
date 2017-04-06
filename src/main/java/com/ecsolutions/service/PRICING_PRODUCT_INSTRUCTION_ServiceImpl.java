package com.ecsolutions.service;

import com.ecsolutions.dao.PRICING_PRODUCT_INSTRUCTION_DAO;
import com.ecsolutions.entity.PRICING_PRODUCT_INSTRUCTION_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
@Service("pRICING_PRODUCT_INSTRUCTION_Service")
public class PRICING_PRODUCT_INSTRUCTION_ServiceImpl implements PRICING_PRODUCT_INSTRUCTION_Service{
    private final PRICING_PRODUCT_INSTRUCTION_DAO pRICING_PRODUCT_INSTRUCTION_DAO;

    @Autowired
    public PRICING_PRODUCT_INSTRUCTION_ServiceImpl(PRICING_PRODUCT_INSTRUCTION_DAO pRICING_PRODUCT_INSTRUCTION_DAO) {
        this.pRICING_PRODUCT_INSTRUCTION_DAO = pRICING_PRODUCT_INSTRUCTION_DAO;
    }

    @Override
    public List<PRICING_PRODUCT_INSTRUCTION_Entity> findProductInstructionByCustd(String customer_code, String search, String orderCol, String orderDir) {
        return pRICING_PRODUCT_INSTRUCTION_DAO.findProductInstructionByCustd(customer_code,search,orderCol,orderDir);
    }

    @Override
    public Long findPITotalByCustd(String customer_code)
    {
        return pRICING_PRODUCT_INSTRUCTION_DAO.findPITotalByCustd(customer_code);
    }
}
