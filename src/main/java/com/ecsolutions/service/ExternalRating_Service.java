package com.ecsolutions.service;

import com.ecsolutions.entity.ExternalRating_Entity;

/**
 * Created by Administrator on 2017/3/29.
 */
public interface ExternalRating_Service {
    ExternalRating_Entity findExternalRatingByCustCode(String customer_code);
}
