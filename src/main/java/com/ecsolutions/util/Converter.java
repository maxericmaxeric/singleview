package com.ecsolutions.util;

import com.ecsolutions.entity.Base_Entity;
import com.ecsolutions.entity.DEPOSIT_ACCOUNT_INFO_Entity;
import com.ecsolutions.entity.Loan_Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
public class Converter {

    public static  List<List<Object>> convertToArrayList(List<Base_Entity> base_entities) {
        List<List<Object>> ret = new ArrayList<>();
        List<Object> entity = new ArrayList<Object>();
        for (Base_Entity base_entity:
                base_entities) {
            if (base_entity instanceof Loan_Entity ) {
                Loan_Entity loan_entity = (Loan_Entity)base_entity;
                entity = loan_entity.convertToArray();
            }else if (base_entity instanceof DEPOSIT_ACCOUNT_INFO_Entity) {
                DEPOSIT_ACCOUNT_INFO_Entity deposit_account_info_entity = (DEPOSIT_ACCOUNT_INFO_Entity)base_entity;
                entity = deposit_account_info_entity.convertToArray();
            }
            ret.add(entity);
        }
        return ret;
    }

}
