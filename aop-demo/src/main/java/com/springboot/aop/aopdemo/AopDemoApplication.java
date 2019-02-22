package com.springboot.aop.aopdemo;

import com.springboot.aop.aopdemo.entity.User;
import com.springboot.aop.aopdemo.service.IUserService;
import com.springboot.aop.aopdemo.service.IUserValidate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@EnableAspectJAutoProxy
public class AopDemoApplication {

    @Autowired
    private IUserService userService;


    @GetMapping("/vp")
    public User getUser(String username, Integer age) {
        User user = new User();
        user.setUsername(username);
        user.setAge(age);
        if (StringUtils.isEmpty(username)) {
            user = null;
        }
        IUserValidate userValidate = (IUserValidate) this.userService;
        if (userValidate.validate(user)) {
            userService.printUser(user);
        }
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
//        IUserService userService = (IUserService) ctx.getBean("userService");
//        IUserValidate userValidate = (IUserValidate) userService;
//        User user = new User();
//        user.setUsername("aaaa");
//        user.setAge(123);
//        boolean validate = userValidate.validate(user);
//        if (validate) {
//            System.out.println("aaaaaaaaaaaaaa");
//        }
//        userService.printUser(user);
    }


//    public static void main(String[] args) {
//        IHello hello = new Hello();
//        IHello proxyBean = (IHello) ProxyBean.getProxyBean(hello, new MyInterceptor());
//        String aaa = proxyBean.sayHello(null);
//        System.out.println("aaa = " + aaa);
//
//
//
//    }




}
