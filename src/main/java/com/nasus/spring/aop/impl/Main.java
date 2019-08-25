package com.nasus.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project Name:ReviewSpring <br/>
 * Package Name:com.nasus.spring.aop.basic <br/>
 * Date:2019/4/20 17:25 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public class Main {

    public static void main(String args[]){

        // 1、创建 Spring 的 IOC 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_aop.xml");

        // 2、从 IOC 容器中获取 bean 实例
        ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);

        // 3、使用 bean
        arithmeticCalculator.add(3,6);

    }

}
