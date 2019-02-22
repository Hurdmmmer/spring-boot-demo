package com.springboot.chapter3;

import com.springboot.chapter3.annotation.EnablePerson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnablePerson
public class SpringBootDemoApplication {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        ctx.close();
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}
