package com.springboot.transacltional.controller;

import com.springboot.transacltional.entity.User;
import com.springboot.transacltional.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/user/{id}")
    public User findUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }
}
