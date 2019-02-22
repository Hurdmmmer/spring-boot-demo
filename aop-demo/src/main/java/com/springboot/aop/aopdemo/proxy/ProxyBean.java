package com.springboot.aop.aopdemo.proxy;

import com.springboot.aop.aopdemo.intercepte.Interceptor;
import com.springboot.aop.aopdemo.invoke.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBean implements InvocationHandler {

    private Object target;

    private Interceptor interceptor;

    public static Object getProxyBean(Object target, Interceptor interceptor) {
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.interceptor = interceptor;
        proxyBean.target = target;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyBean);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 异常标识
        boolean exceptionFlag = false;
        // 创建包装类 传入 jdk 动态代理生成的 参数， 方法， 目标对象
        // TODO 这里需要注意的是，不能使用 invoke 方法传入的代理对象， 只能使用源目标对象，否则将出现死循环
        Invocation invocation = new Invocation(args, method, target);
        Object retObj = null;

        try {
            // 根据代理对象执行相应的 前置， 环绕， 后置方法
            if (this.interceptor.before()) {
                retObj = this.interceptor.around(invocation);
            } else {
                retObj = method.invoke(target, args);
            }
        } catch (Exception e) {
            exceptionFlag = true;
        }
        this.interceptor.after();
        // 异常目标对象是否有异常
        if (exceptionFlag) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterRetuning();
            return retObj;
        }

        return null;
    }
}
