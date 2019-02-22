package com.springboot.chapter3.config;

import com.springboot.chapter3.pojo.BussinessPerson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan(basePackages = "com.springboot.chapter3.*")
public class AppConfig {
    @Bean
    public BussinessPerson bussinessPerson() {
        return new BussinessPerson();
    }
}
