package com.ecsolutions.service;

import com.ecsolutions.dao.CallMemo_DAO;
import com.ecsolutions.entity.CallMemo_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@Service("CallMemo_Service")
public class CallMemo_ServiceImpl implements CallMemo_Service {
    private CallMemo_DAO callMemo_dao;

    @Autowired
    public CallMemo_ServiceImpl(CallMemo_DAO callMemo_dao) {
        this.callMemo_dao = callMemo_dao;
    }

    @Override
    public List<CallMemo_Entity> findCallMemoByCustCode(String customer_code) {
        List<CallMemo_Entity> callMemo_entities = new ArrayList<>();
        List<String> dates = callMemo_dao.findDatesByCustCode(customer_code);
        for (String date:
             dates) {
            CallMemo_Entity callMemo_entity = new CallMemo_Entity();
            callMemo_entity.setCALLDTE(date);
            callMemo_entity.setMemo_entityList(callMemo_dao.findMemoByCustCode_Date(customer_code, date));
            callMemo_entities.add(callMemo_entity);
        }
        return callMemo_entities;
    }
}
