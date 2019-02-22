package com.springboot.aop.aopdemo.intercepte;


import com.springboot.aop.aopdemo.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {
    /** 事前方法 */
    public boolean before();
    /** 事后方法 */
    public void after();
    /**
     ＊取代原有事件方法
     * @param invocation 一回调参数，可以通过它的 proceed 方法 回调原有事件
     * @return 原有事件返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;
    /** 是否返回方法 事件没有发生异常执行 */
    public void afterRetuning();
    /** 是否返回方法 事件有发生异常执行 */
    public void afterThrowing();
    /** 是否使用 around 方法取代原有方法 */
    boolean useAround();

}
