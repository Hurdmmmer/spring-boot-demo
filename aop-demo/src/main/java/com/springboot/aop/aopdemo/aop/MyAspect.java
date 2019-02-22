package com.springboot.aop.aopdemo.aop;

import com.springboot.aop.aopdemo.entity.User;
import com.springboot.aop.aopdemo.service.IUserValidate;
import com.springboot.aop.aopdemo.service.impl.UserValidateImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {


    /** 使用 aop 对原有类进行增强功能 */
    @DeclareParents(
            value = "com.springboot.aop.aopdemo.service.impl.UserServiceImpl"
            , defaultImpl = UserValidateImpl.class)
    public IUserValidate userValidate;


    @Around("@annotation(Test) && args(user)")
    public Object around(ProceedingJoinPoint pjp, User user) throws Throwable {
        System.out.println(user);
        Object result = pjp.proceed();
        return result;
    }
}
