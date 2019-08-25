package com.nasus.spring.aop.basic;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Project Name:ReviewSpring <br/>
 * Package Name:com.nasus.spring.aop.basic <br/>
 * Date:2019/4/20 17:15 <br/>
 * <b>Description:</b> TODO: 描述该类的作用 <br/>
 *
 * @author <a href="turodog@foxmail.com">nasus</a><br/>
 * Copyright Notice =========================================================
 * This file contains proprietary information of Eastcom Technologies Co. Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2019 =======================================================
 */
public class ArithmeticCalculatorLoggingProxy {

    // 要代理的对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target){
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy(){
        ArithmeticCalculator proxy = null;

        // 代理对象是由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        // 代理对象的类型，即其中有哪些方法
        Class [] interfaces = new Class[]{ArithmeticCalculator.class};

        // 当调用代理对象其中的方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            /**
             * proxy: 代理对象。 一般不使用该对象
             * method: 正在被调用的方法
             * args: 调用方法传入的参数
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                // 前置通知
                System.out.println("[before] The method " + methodName + " begins with " + Arrays.asList(args));

                // 执行目标方法
                Object result = null;

                try {
                    // 返回通知，可以访问到方法的返回值
                    result = method.invoke(target, args);
                }catch (Exception e){
                    // 异常通知，可以访问到出现的异常
                    e.printStackTrace();
                }

                // 后置通知，方法可能出异常，所以访问不到方法返回值
                System.out.println("[after] The method " + methodName + " ends with " + result);

                return result;
            }
        };
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }

}
