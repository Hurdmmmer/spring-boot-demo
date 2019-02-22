package com.springboot.chapter3.config;

import com.springboot.chapter3.interfaces.Person;
import com.springboot.chapter3.pojo.TestPersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class TestConfig {
    @Bean
    public Person testPerson() {
        return new TestPersion();
    }
}
