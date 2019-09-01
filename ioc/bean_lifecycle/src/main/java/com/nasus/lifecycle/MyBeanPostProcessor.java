package com.nasus.lifecycle;

import com.nasus.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Project Name:review_spring <br/>
 * Package Name:PACKAGE_NAME <br/>
 * Date:2019/9/1 16:25 <br/>
 *
 * @author <a href="turodog@foxmail.com">chenzy</a><br/>
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 容器加载的时候会加载一些其他的 bean，会调用初始化前和初始化后方法
    // 这次只关注 Person 的生命周期
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Person){
            System.out.println("6、初始化 Person 之前执行的方法");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Person){
            System.out.println("10、初始化 Person 完成之后执行的方法");
        }
        return bean;
    }

}
