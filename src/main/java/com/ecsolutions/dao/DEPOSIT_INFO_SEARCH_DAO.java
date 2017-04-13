package com.ecsolutions.dao;

import com.ecsolutions.dao.sqlProvider.DEPOSIT_INFO_SEARCH_Provider;
import com.ecsolutions.entity.DEPOSIT_INFO_SEARCH_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-3-16.
 */
@Repository
public interface DEPOSIT_INFO_SEARCH_DAO {
    @SelectProvider(type = DEPOSIT_INFO_SEARCH_Provider.class,method = "searchInfoByCustCode")
    List<DEPOSIT_INFO_SEARCH_Entity> searchInfoByCustCode(@Param("dp_account_no") String dp_account_no,@Param("ln_account_no") String ln_account_no,@Param("customer_code") String customer_code,@Param("customer_full_name") String customer_full_name,@Param("identity_no") String identity_no,@Param("userid") String userid);
}
