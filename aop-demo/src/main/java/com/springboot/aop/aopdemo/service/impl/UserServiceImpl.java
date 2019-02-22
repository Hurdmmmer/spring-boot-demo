package com.springboot.aop.aopdemo.service.impl;

import com.springboot.aop.aopdemo.aop.Test;
import com.springboot.aop.aopdemo.entity.User;
import com.springboot.aop.aopdemo.service.IUserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Test
    @Override
    public void printUser(User user) {
        System.out.println("user = " + user);
    }
}
