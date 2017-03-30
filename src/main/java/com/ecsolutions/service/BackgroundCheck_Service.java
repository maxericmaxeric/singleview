package com.ecsolutions.service;

import com.ecsolutions.entity.BackgroundCheck_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public interface BackgroundCheck_Service {
    Long findBackgroundCheck_TotalByCustCode(String customer_code);

    List<BackgroundCheck_Entity> findBackgroundCheck(String customer_code, String search, String orderCol, String orderDir);
}
