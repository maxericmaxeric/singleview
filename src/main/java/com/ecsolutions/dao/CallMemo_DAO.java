package com.ecsolutions.dao;

import com.ecsolutions.entity.Memo_Entity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@Repository
public interface CallMemo_DAO {

    @Select("SELECT DISTINCT CALLDTE FROM CALL_MEMO WHERE TRIM(PRTYNO) = TRIM(#{customer_code}) ORDER BY CALLDTE DESC")
    @ResultType(String.class)
    List<String> findDatesByCustCode(String customer_code);

    @Select("SELECT CALLCUS,PURPOSE,SUMMAY1,ACTION1 FROM CALL_MEMO WHERE TRIM(PRTYNO) = TRIM(#{customer_code}) AND TRIM(CALLDTE） = TRIM(#{date})")
    @ResultType(Memo_Entity.class)
    List<Memo_Entity> findMemoByCustCode_Date(@Param("customer_code") String customer_code, @Param("date") String date);
}
