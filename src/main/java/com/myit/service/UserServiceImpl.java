package com.myit.service;

import com.myit.dao.UserMapper;
import com.myit.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    UserMapper  userMapper;
    @Override
    public Users getUsersById(String userCode) {
        return userMapper.getUsersById(userCode);
    }

    @Override
    public int updateUserTimeById(String userCode, String loginTime) {
        return userMapper.updateUserTimeById(userCode,loginTime);
    }
}
