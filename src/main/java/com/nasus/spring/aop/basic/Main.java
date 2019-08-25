package com.nasus.spring.aop.basic;

import com.nasus.spring.factorybean.Student;
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

        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();

        int result = proxy.add(1,2);
        System.out.println("--->" + result);

        result = proxy.div(4,2);
        System.out.println("--->" + result);

    }

}
