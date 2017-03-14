package com.ecsolutions.dao;

import com.ecsolutions.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/3/14.
 */
@Repository
public interface UserDAO {
    // 插入一行新数据
    @Insert("INSERT INTO spring_boot_mybatis_user(username,phone) VALUES(#{userEntity.username},#{userEntity.phone})")
    @Options(useGeneratedKeys = true, keyProperty = "userEntity.id")  // 将自动生成的主键重新设置到实体中，便于业务逻辑处理
    void insertUser(@Param("userEntity") UserEntity userEntity);


    // 根据id查询用户
    @Select("SELECT * FROM spring_boot_mybatis_user WHERE id = #{id}")
    @ResultType(UserEntity.class)
    UserEntity findUserById(@Param("id") int id);
}
