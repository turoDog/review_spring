package com.nasus.spring.aop.impl;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 1. 加入 jar 包
 * com.springsource.net.sf.cglib-2.2.0.jar
 * com.springsource.org.aopalliance-1.0.0.jar
 * com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
 * spring-aspects-4.0.0.RELEASE.jar
 *
 * 2. 在 Spring 的配置文件中加入 aop 的命名空间。
 *
 * 3. 基于注解的方式来使用 AOP
 * 3.1 在配置文件中配置自动扫描的包: <context:component-scan base-package="com.atguigu.spring.aop"></context:component-scan>
 * 3.2 加入使 AspjectJ 注解起作用的配置: <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 * 为匹配的类自动生成动态代理对象.
 *
 * 4. 编写切面类:
 * 4.1 一个一般的 Java 类
 * 4.2 在其中添加要额外实现的功能.
 *
 * 5. 配置切面
 * 5.1 切面必须是 IOC 中的 bean: 实际添加了 @Component 注解
 * 5.2 声明是一个切面: 添加 @Aspect
 * 5.3 声明通知: 即额外加入功能对应的方法.
 * 5.3.1 前置通知: @Before("execution(public int com.atguigu.spring.aop.ArithmeticCalculator.*(int, int))")
 * @Before 表示在目标方法执行之前执行 @Before 标记的方法的方法体.
 * @Before 里面的是切入点表达式:
 *
 * 6. 在通知中访问连接细节: 可以在通知方法中添加 JoinPoint 类型的参数, 从中可以访问到方法的签名和方法的参数.
 *
 * 7. @After 表示后置通知: 在方法执行之后执行的代码.
 */

//通过添加 @EnableAspectJAutoProxy 注解声明一个 bean 是一个切面!
@Component
@Aspect
public class LoggingAspect {

    /**
     * 在方法正常开始前执行的代码
     * @param joinPoint
     */
    @Before("execution(public int com.nasus.spring.aop.impl.*.*(int, int))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();

        System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
    }

    /**
     * 在方法执行后执行的代码，无论方法是否抛出异常
     * @param joinPoint
     */
    @After("execution(* com.nasus.spring.aop.impl.*.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }


    /**
     * 在方法正常结束后执行的代码
     * 返回通知是可以访问到方法的返回值的
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "execution(public int com.nasus.spring.aop.impl.*.*(int, int))",
    returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }

    /**
     * 在目标方法出现异常时，会执行的代码
     * 可以访问到异常对象，可以指定在出现特定异常时再执行通知代码
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "execution(public int com.nasus.spring.aop.impl.*.*(int, int))",
    throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        String methodNames = joinPoint.getSignature().getName();
        System.out.println("The method " + methodNames + " occurs exception: " + ex);
    }

    /**
     * 环绕通知需要携带 ProceedingJoinPoint 类型参数
     * 环绕通知类似于动态代理的全过程； ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值极为目标方法的返回值
     * @param pjd
     * @return
     */
    @Around("execution(public int com.nasus.spring.aop.impl.*.*(int, int))")
    public Object aroundMethod(ProceedingJoinPoint pjd){

        Object result = null;
        String methodName = pjd.getSignature().getName();

        try {
            // 前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));

            // 执行目标方法
            result = pjd.proceed();

            // 返回通知
            System.out.println("The method " + methodName + " ends with " + result);
        }catch (Throwable e) {
            // 异常通知
            System.out.println("The method " + methodName + " occurs exception: " + e);
            throw new RuntimeException(e);
        }

        // 后置通知
        System.out.println("The method " + methodName + " ends");

        return result;
    }

}
