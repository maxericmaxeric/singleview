package com.ecsolutions.dao;

import com.ecsolutions.entity.Organization_Entity;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/10.
 */
@Repository
public interface Organization_DAO {
    @Select("SELECT ORGANIZATION_CODE, ORGANIZATION_DESC FROM ORGANIZATION_INFO")
    @ResultType(Organization_Entity.class)
    List<Organization_Entity> getOrganizations();
}
