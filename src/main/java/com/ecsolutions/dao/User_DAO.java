package com.ecsolutions.dao;

import com.ecsolutions.entity.User_Entity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/1.
 */
@Repository
public interface User_DAO {

    @Select("SELECT TRIM(USERID) USERID, TRIM(USERNAME) USERNAME, TRIM(STATUS) STATUS, TRIM(ADMINFLAG) ADMINFLAG FROM CSVUSER WHERE TRIM(USERID) = TRIM(#{userid}) AND TRIM(PASSWORD) = TRIM(#{password})")
    @ResultType(User_Entity.class)
    User_Entity findUser(@Param("userid") String userid, @Param("password") String password);

    @Insert("INSERT INTO CSVUSER(USERID,PASSWORD,USERNAME,ORGANIZATION,GROUPID,STATUS,ADMINFLAG) VALUES(#{userid},#{password},#{username},#{organization},#{groupid},#{status},#{adminflag})")
    void createUser(User_Entity user_entity) throws DataAccessException;

    @Select("SELECT * FROM CSVUSER WHERE TRIM(USERID) = #{userid} ")
    @ResultType(User_Entity.class)
    User_Entity getUser(String userid);
}
