package com.ecsolutions.service;

import com.ecsolutions.entity.CallMemo_Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
public interface CallMemo_Service {
    List<CallMemo_Entity> findCallMemoByCustCode(String customer_code);
}
