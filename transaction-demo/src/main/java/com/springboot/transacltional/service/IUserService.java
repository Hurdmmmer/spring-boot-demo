package com.springboot.transacltional.service;

import com.springboot.transacltional.entity.User;

public interface IUserService {
    User getUser(int id);

    int insertUser(User user);
}
