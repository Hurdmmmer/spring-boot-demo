package com.springboot.chapter3.pojo;

import com.springboot.chapter3.interfaces.Animal;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗能够看家");
    }
}
