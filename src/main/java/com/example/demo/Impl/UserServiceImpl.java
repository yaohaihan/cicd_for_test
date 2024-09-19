package com.example.demo.Impl;

import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void addUser(String username, String password, String email, String gender, String status, byte[] avator) {
        userMapper.addUser(username, password, email, gender, status, avator);

    }

    @Override
    public User getUser(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }
}
