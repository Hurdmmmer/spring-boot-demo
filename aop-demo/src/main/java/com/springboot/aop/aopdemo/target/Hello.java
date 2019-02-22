package com.springboot.aop.aopdemo.target;

public class Hello implements IHello{


    @Override
    public String sayHello(String name) {
        if (name == null) {
            throw new RuntimeException("name is empty");
        }
        return name + ": hello world";
    }
}
