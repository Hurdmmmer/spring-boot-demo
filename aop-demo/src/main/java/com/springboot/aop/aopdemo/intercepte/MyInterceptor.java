package com.springboot.aop.aopdemo.intercepte;

import com.springboot.aop.aopdemo.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("before ......");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after ...");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before ...");
        Object result = invocation.proceed();
        System.out.println("around after ...");
        return result;
    }

    @Override
    public void afterRetuning() {
        System.out.println("after retuning ....");
    }

    @Override
    public void afterThrowing() {
        System.out.println("after throwing");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
