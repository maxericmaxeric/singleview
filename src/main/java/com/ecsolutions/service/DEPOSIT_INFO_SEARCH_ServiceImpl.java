package com.ecsolutions.service;

import com.ecsolutions.dao.DEPOSIT_INFO_SEARCH_DAO;
import com.ecsolutions.entity.DEPOSIT_INFO_SEARCH_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-3-16.
 */
@Service("dEPOSIT_INFO_SEARCH_Service")
public class DEPOSIT_INFO_SEARCH_ServiceImpl implements DEPOSIT_INFO_SEARCH_Service{
    private final DEPOSIT_INFO_SEARCH_DAO dEPOSIT_INFO_SEARCH_DAO;

    @Autowired
    public DEPOSIT_INFO_SEARCH_ServiceImpl(DEPOSIT_INFO_SEARCH_DAO dEPOSIT_INFO_SEARCH_DAO) {
        this.dEPOSIT_INFO_SEARCH_DAO = dEPOSIT_INFO_SEARCH_DAO;
    }

    @Override
    public List<DEPOSIT_INFO_SEARCH_Entity> searchInfoByCustCode(String dp_account_no, String ln_account_no, String customer_code, String customer_full_name, String identity_no,String userid)
    {
        return dEPOSIT_INFO_SEARCH_DAO.searchInfoByCustCode(dp_account_no,ln_account_no,customer_code,customer_full_name,identity_no,userid);
    }
}
