package com.nasus.spring.aop.basic;

/**
 * Project Name:ReviewSpring <br/>
 * Package Name:com.nasus.spring.aop.basic <br/>
 * Date:2019/4/20 17:08 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator{

    public int add(int i, int j) {
        System.out.println("The method add begins with [" + i + "," + j + "]");
        int result = i + j;
        System.out.println("The method add ends with " + result);
        return result;
    }

    public int sub(int i, int j) {
        System.out.println("The method sub begins with [" + i + "," + j + "]");
        int result = i - j;
        System.out.println("The method sub ends with " + result);
        return result;
    }

    public int mul(int i, int j) {
        System.out.println("The method mul begins with [" + i + "," + j + "]");
        int result = i * j;
        System.out.println("The method mul ends with " + result);
        return result;
    }

    public int div(int i, int j) {
        System.out.println("The method div begins with [" + i + "," + j + "]");
        int result = i / j;
        System.out.println("The method div ends with " + result);
        return result;
    }

}
