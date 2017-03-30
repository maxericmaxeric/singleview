package com.ecsolutions.service;

import com.ecsolutions.dao.RelatedParty_DAO;
import com.ecsolutions.entity.RelatedParty_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@Service("RelatedParty_Service")
public class RelatedParty_ServiceImpl implements RelatedParty_Service {
    private RelatedParty_DAO relatedparty_dao;

    @Autowired
    public RelatedParty_ServiceImpl(RelatedParty_DAO relatedparty_dao) {
        this.relatedparty_dao = relatedparty_dao;
    }

    @Override
    public List<RelatedParty_Entity> findRelatedPartyByCustCode(String customer_code) {
        return this.relatedparty_dao.findRelatedPartyByCustCode(customer_code);
    }

    @Override
    public Long findRelatedParty_TotalByCustCode(String customer_code) {
        return this.relatedparty_dao.findRelatedParty_TotalByCustCode(customer_code);
    }

    @Override
    public List<RelatedParty_Entity> findRelatedParty(String customer_code, String search, String orderCol, String orderDir) {
        return this.relatedparty_dao.findRelatedParty(customer_code, search, orderCol, orderDir);
    }
}
