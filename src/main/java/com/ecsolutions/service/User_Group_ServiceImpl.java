package com.ecsolutions.service;

import com.ecsolutions.dao.User_Group_Dao;
import com.ecsolutions.entity.User_Group_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-4-10.
 */
@Service("uSER_GROUP_Service")
public class User_Group_ServiceImpl implements User_Group_Service{
    private final User_Group_Dao user_group_dao;

    @Autowired
    public User_Group_ServiceImpl(User_Group_Dao user_group_dao) {
        this.user_group_dao = user_group_dao;
    }

    @Override
    public List<User_Group_Entity> findUserGroupInfo()
    {
        return user_group_dao.findUserGroupInfo();
    }

    @Override
    public void createUserGroup(String groupid,String groupdesc,String remark) throws DataAccessException
    {
        user_group_dao.createUserGroup(groupid,groupdesc,remark);
    }

    @Override
    public void updateUserGroup(String groupid,String groupdesc,String remark)
    {
        user_group_dao.updateUserGroup(groupid,groupdesc,remark);
    }

    @Override
    public void deleteUserGroup(String groupid)
    {
        try{
            user_group_dao.deleteUserGroup(groupid);
            user_group_dao.deleteGroup_updateuser(groupid);
            user_group_dao.deleteFunctions(groupid);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getFunctions(String groupid) {
        return user_group_dao.getFunctions(groupid);
    }

    @Override
    public void updateFunctions(String groupid, String[] functions) {
        user_group_dao.deleteFunctions(groupid);
        for (String function:
             functions) {
            user_group_dao.insertFunctions(groupid, function);
        }

    }


}
