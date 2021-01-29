package com.myit.service;

import com.myit.dao.UserMapper;
import com.myit.pojo.Users;
import org.springframework.stereotype.Service;


public interface UserService {

    public Users getUsersById(String userCode);
    public int updateUserTimeById(String userCode,String loginTime);
}
