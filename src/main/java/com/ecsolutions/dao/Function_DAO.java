package com.ecsolutions.dao;

import com.ecsolutions.entity.Function_Entity;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */
@Repository
public interface Function_DAO {
    @Select("SELECT TRIM(FUNCTIONID) FUNCTIONID,TRIM(FUNCTIONDESC) FUNCTIONDESC,TRIM(TAB) TAB FROM CSVFUNCTION")
    @ResultType(Function_Entity.class)
    List<Function_Entity> getFunctions();
}

