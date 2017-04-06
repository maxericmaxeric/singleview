package com.ecsolutions.service;

import com.ecsolutions.entity.PRICING_STANDING_INSTRUCTION_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
public interface PRICING_STANDING_INSTRUCTION_Service {
    List<PRICING_STANDING_INSTRUCTION_Entity> findStandingInstructionByCustd(String customer_code, String search, String orderCol, String orderDir);
    Long findSITotalByCustd(String customer_code);

}
