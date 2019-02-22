package com.springboot.aop.aopdemo.service.impl;

import com.springboot.aop.aopdemo.entity.User;
import com.springboot.aop.aopdemo.service.IUserValidate;
import org.springframework.stereotype.Service;

@Service
public class UserValidateImpl implements IUserValidate {
    @Override
    public boolean validate(User user) {
        System.out.println("引入新接口： " + UserValidateImpl.class.getSimpleName());
        return user != null;
    }
}
