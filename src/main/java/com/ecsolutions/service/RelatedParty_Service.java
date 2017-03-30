package com.ecsolutions.service;

import com.ecsolutions.entity.RelatedParty_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface RelatedParty_Service {
    List<RelatedParty_Entity> findRelatedPartyByCustCode(String customer_code);

    Long findRelatedParty_TotalByCustCode(String customer_code);

    List<RelatedParty_Entity> findRelatedParty(String customer_code, String search, String orderCol, String orderDir);
}
