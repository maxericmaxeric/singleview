package com.ecsolutions.service;

import com.ecsolutions.entity.PRICING_PRODUCT_INSTRUCTION_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017-3-27.
 */
public interface PRICING_PRODUCT_INSTRUCTION_Service {
    List<PRICING_PRODUCT_INSTRUCTION_Entity> findProductInstructionByCustd(String customer_code, String search, String orderCol, String orderDir);
    Long findPITotalByCustd(String customer_code);
}
