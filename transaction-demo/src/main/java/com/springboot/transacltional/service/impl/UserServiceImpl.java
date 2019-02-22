package com.springboot.transacltional.service.impl;

import com.springboot.transacltional.dao.UserMapper;
import com.springboot.transacltional.entity.User;
import com.springboot.transacltional.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }


}
