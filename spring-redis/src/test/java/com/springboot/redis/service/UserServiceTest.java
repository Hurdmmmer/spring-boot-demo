package com.springboot.redis.service;

import com.springboot.redis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("xxxx");
        User user1 = userService.insertUser(user);
    }

    @Test
    public void getUser() {
        User user = userService.getUser(0);
        System.out.println(user);
    }

    @Test
    public void updateUser() {

        User user = new User();
        user.setUsername("hahahaha");
        user.setId(0);
        User user1 = userService.updateUser(user);
        System.out.println("user1 = " + user1);
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(0);
    }
}