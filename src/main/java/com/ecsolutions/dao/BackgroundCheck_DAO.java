package com.ecsolutions.dao;

import com.ecsolutions.entity.BackgroundCheck_Entity;
import com.ecsolutions.entity.RelatedParty_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
@Repository
public interface BackgroundCheck_DAO {

    @Select("SELECT COUNT(*) FROM BACKGROUND_CHECK WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(Long.class)
    Long findBackgroundCheck_TotalByCustCode(@Param("customer_code") String customer_code);

    @Select("SELECT CHECK_DATE,CHECK_ITEM,CHECK_RESULT from BACKGROUND_CHECK WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code}) ORDER BY ${orderCol}  ${orderDir}")
    @ResultType(RelatedParty_Entity.class)
    List<BackgroundCheck_Entity> findBackgroundCheck(@Param("customer_code") String customer_code, @Param("search") String search, @Param("orderCol") String orderCol, @Param("orderDir") String orderDir);
}
