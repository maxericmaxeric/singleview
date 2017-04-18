package com.ecsolutions.dao;

import com.ecsolutions.dao.sqlProvider.User_sqlProvider;
import com.ecsolutions.entity.Function_Entity;
import com.ecsolutions.entity.User_Entity;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Select("SELECT TRIM(USERID) USERID, TRIM(USERNAME) USERNAME, TRIM(PASSWORD) PASSWORD, TRIM(ORGANIZATION) ORGANIZATION, TRIM(GROUPID) GROUPID, TRIM(STATUS) STATUS, TRIM(ADMINFLAG) ADMINFLAG FROM CSVUSER WHERE TRIM(USERID) = #{userid} ")
    @ResultType(User_Entity.class)
    User_Entity getUser(String userid);

    @Select("SELECT COUNT(*) FROM CSVUSER")
    @ResultType(Long.class)
    Long findUserCount();

    @SelectProvider(type = User_sqlProvider.class, method = "getSql")
    @ResultType(User_Entity.class)
    List<User_Entity> findUserList(@Param("search") String search, @Param("orderCol") String orderCol, @Param("orderDir") String orderDir);

    @Update("UPDATE CSVUSER SET " +
            "USERNAME = #{username}," +
            "PASSWORD = #{password}, " +
            "ORGANIZATION = #{organization}," +
            "GROUPID = #{groupid}," +
            "STATUS = #{status}," +
            "ADMINFLAG = #{adminflag} " +
            "WHERE TRIM(USERID) = #{userid}" )
    void update(User_Entity user_entity);

    @Delete("DELETE FROM CSVUSER WHERE TRIM(USERID) = #{userid}")
    void delete(String userid);

    @Select("SELECT A.FUNCTIONID, TAB FROM CSVFUNCTION,\n" +
            "(SELECT FUNCTIONID FROM CSVGRPFUNC\n" +
            "WHERE GROUPID = (SELECT GROUPID FROM CSVUSER WHERE TRIM(USERID) = TRIM(#{userid}))) A\n" +
            "WHERE CSVFUNCTION.FUNCTIONID = A.FUNCTIONID\n" +
            "ORDER BY TAB")
    List<Function_Entity> getFunctions(String userid);

}
