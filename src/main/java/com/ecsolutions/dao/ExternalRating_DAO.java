package com.ecsolutions.dao;

import com.ecsolutions.entity.ExternalRating_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/3/29.
 */
@Repository
public interface ExternalRating_DAO {

    @Select("SELECT LCY_RATING, FCY_RATING,RATING_DATE,RATING_AGENCY FROM EXTERNAL_RATING WHERE CUSTOMER_CODE = #{customer_code}")
    @ResultType(ExternalRating_Entity.class)
    ExternalRating_Entity findExternalRatingByCustCode(@Param("customer_code") String customer_code);
}
