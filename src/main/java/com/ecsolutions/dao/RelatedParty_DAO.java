package com.ecsolutions.dao;

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
public interface RelatedParty_DAO {

    @Select("SELECT CUSTOMER_CODE,RELATED_PARTY, RELATED_PARTY_NAME,RELATIONSHIP, SHAREHOLDING FROM RELATED_PARTY WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(RelatedParty_Entity.class)
    List<RelatedParty_Entity> findRelatedPartyByCustCode(@Param("customer_code") String customer_code);

    @Select("SELECT COUNT(*) FROM RELATED_PARTY WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code})")
    @ResultType(Long.class)
    Long findRelatedParty_TotalByCustCode(@Param("customer_code") String customer_code);

    @Select("SELECT CUSTOMER_CODE,RELATED_PARTY, RELATED_PARTY_NAME,RELATIONSHIP, SHAREHOLDING FROM RELATED_PARTY WHERE TRIM(CUSTOMER_CODE) = TRIM(#{customer_code}) ORDER BY ${orderCol}  ${orderDir}")
    @ResultType(RelatedParty_Entity.class)
    List<RelatedParty_Entity> findRelatedParty(@Param("customer_code") String customer_code, @Param("search") String search, @Param("orderCol") String orderCol, @Param("orderDir") String orderDir);
}
