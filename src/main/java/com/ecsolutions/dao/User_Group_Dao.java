package com.ecsolutions.dao;

import com.ecsolutions.entity.User_Group_Entity;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-4-10.
 */
@Repository
public interface User_Group_Dao {
    @Select("select * from csvgroup")
    @ResultType(User_Group_Entity.class)
    List<User_Group_Entity> findUserGroupInfo();

    @Insert("INSERT INTO CSVGROUP VALUES(#{groupid},#{groupdesc},#{remark})")
    void createUserGroup(@Param("groupid") String groupid,@Param("groupdesc") String groupdesc,@Param("remark") String remark) throws DataAccessException;

    @Update("UPDATE CSVgroup SET " +
            "GROUPDESC = #{groupdesc}," +
            "REMARK = #{remark} " +
            "WHERE TRIM(GROUPID) = #{groupid}" )
    void updateUserGroup(@Param("groupid") String groupid,@Param("groupdesc") String groupdesc,@Param("remark") String remark);


    @Delete("DELETE FROM CSVGROUP WHERE TRIM(GROUPID) = #{groupid}")
    void deleteUserGroup(@Param("groupid") String groupid);

    @Select("SELECT TRIM(GROUPID) FROM CSVGRPFUNC WHERE TRIM(GROUPID) = TRIM(#{groupid})")
    @ResultType(String.class)
    List<String> getFunctions(@Param("groupid") String groupid);
}
