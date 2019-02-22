package com.springboot.chapter3.pojo;

import com.springboot.chapter3.interfaces.Animal;
import com.springboot.chapter3.interfaces.Person;

import javax.annotation.PostConstruct;

public class TestPersion implements Person {
    @Override
    public void service() {
        System.out.println("这是测试");
    }

    @Override
    public void setAnimal(Animal animal) {

    }
    @PostConstruct
    public void init() {
        System.out.println("测试 ImportSelect 接口");
    }
}
