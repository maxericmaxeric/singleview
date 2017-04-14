package com.ecsolutions.service;

import com.ecsolutions.entity.User_Group_Entity;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by Administrator on 2017-4-10.
 */
public interface User_Group_Service {
    List<User_Group_Entity> findUserGroupInfo();
    void createUserGroup(String groupid,String groupdesc,String remark) throws DataAccessException;
    void updateUserGroup(String groupid,String groupdesc,String remark);
    void deleteUserGroup(String groupid);

    List<String> getFunctions(String groupid);

    void updateFunctions(String groupid, String[] functions);
}
