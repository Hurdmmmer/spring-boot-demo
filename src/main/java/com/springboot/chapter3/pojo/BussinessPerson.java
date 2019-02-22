package com.springboot.chapter3.pojo;

import com.springboot.chapter3.interfaces.Person;
import com.springboot.chapter3.interfaces.Animal;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/** Spring Bean 生命周期 */
//@Component
public class BussinessPerson implements Person, BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {

    private Animal animal;

    @Override
    public void service() {
        animal.use();
    }

    @Autowired
    @Qualifier("cat")
    @Override
    public void setAnimal(Animal animal) {
        System.out.println("DI 属性注入");
        this.animal = animal;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("1.beanName = " + beanName + "[调用BeanNameAware接口方法，获取BeanName]");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("2.beanFactory = " + "[调用 BeanFactoryAware 接口方法，获取BeanFactory]");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("3.调用 ApplicationContextAware 接口方法， 获取 IOC容器");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        animal.use();
        System.out.println("4.属性已经注入完成");
        System.out.println("4.调用 InitializingBean 接口方法， 再依赖注入属性后执行");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("5.调用 DisposableBean 接口方法，执行Bean对象销毁");
    }
}
