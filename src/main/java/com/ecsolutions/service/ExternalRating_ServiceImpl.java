package com.ecsolutions.service;

import com.ecsolutions.dao.ExternalRating_DAO;
import com.ecsolutions.entity.ExternalRating_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/29.
 */
@Service("externalRating_service")
public class ExternalRating_ServiceImpl implements  ExternalRating_Service{
    private ExternalRating_DAO externalRating_dao;

    @Autowired
    public ExternalRating_ServiceImpl(ExternalRating_DAO externalRating_dao) {
        this.externalRating_dao = externalRating_dao;
    }

    @Override
    public ExternalRating_Entity findExternalRatingByCustCode(String customer_code) {
        return externalRating_dao.findExternalRatingByCustCode(customer_code);
    }
}
