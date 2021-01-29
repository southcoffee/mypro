package com.myit.dao;

import com.myit.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select  *  from  users where userCode=#{userCode}")
    public Users getUsersById(@Param("userCode") String userCode);
    @Update("update users  set lastLoginTime=#{loginTime} where userCode=#{userCode}")
    public int updateUserTimeById(@Param("userCode") String userCode,@Param("loginTime") String loginTime);
}
