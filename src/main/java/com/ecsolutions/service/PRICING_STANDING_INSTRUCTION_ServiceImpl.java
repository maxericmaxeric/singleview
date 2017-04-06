package com.ecsolutions.service;

import com.ecsolutions.dao.PRICING_STANDING_INSTRUCTION_DAO;
import com.ecsolutions.entity.PRICING_STANDING_INSTRUCTION_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
@Service("pRICING_STANDING_INSTRUCTION_Service")
public class PRICING_STANDING_INSTRUCTION_ServiceImpl implements PRICING_STANDING_INSTRUCTION_Service{
    private final PRICING_STANDING_INSTRUCTION_DAO pRICING_STANDING_INSTRUCTION_DAO;

    @Autowired
    public PRICING_STANDING_INSTRUCTION_ServiceImpl(PRICING_STANDING_INSTRUCTION_DAO pRICING_STANDING_INSTRUCTION_DAO) {
        this.pRICING_STANDING_INSTRUCTION_DAO = pRICING_STANDING_INSTRUCTION_DAO;
    }

    @Override
    public List<PRICING_STANDING_INSTRUCTION_Entity> findStandingInstructionByCustd(String customer_code, String search, String orderCol, String orderDir) {
        return pRICING_STANDING_INSTRUCTION_DAO.findStandingInstructionByCustd(customer_code,search,orderCol,orderDir);
    }

    @Override
    public Long findSITotalByCustd(String customer_code)
    {
        return pRICING_STANDING_INSTRUCTION_DAO.findSITotalByCustd(customer_code);
    }
}
