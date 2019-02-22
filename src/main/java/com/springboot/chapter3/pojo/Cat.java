package com.springboot.chapter3.pojo;

import com.springboot.chapter3.interfaces.Animal;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("猫可以撸猫");
    }
}
