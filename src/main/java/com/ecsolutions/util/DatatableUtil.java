package com.ecsolutions.util;

import com.ecsolutions.entity.Loan_Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
public class DatatableUtil {

    public static  List<List<Object>> convertToArrayList(List<Loan_Entity> loan_entities) {
        List<List<Object>> ret = new ArrayList<>();
        List<Object> entity = new ArrayList<Object>();
        for (Loan_Entity loan_entity:
                loan_entities) {
            entity = convertToArray(loan_entity);
            ret.add(entity);
        }
        return ret;
    }

    private static List<Object> convertToArray(Loan_Entity loan_entity) {
        List<Object> ret = new ArrayList<Object>();
        ret.add(loan_entity.getBranch());
        ret.add(loan_entity.getLn_account_no());
        ret.add(loan_entity.getLoan_type());
        ret.add(loan_entity.getLine_no());
        ret.add(loan_entity.getPrincipal_currency());
        ret.add(loan_entity.getPrincipal_amount());
        ret.add(loan_entity.getValue_date());
        ret.add(loan_entity.getMaturity_date());
        ret.add(loan_entity.getBalance_currency());
        ret.add(loan_entity.getBalance());
        ret.add(loan_entity.getAccount_status());

        return ret;
    }
}
