package com.tcl.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 对输入计算器的两个值合法性确认
 * 因此，引出切面优先级
 */
@Component
@Aspect
@Order(1)   //数值越小，优先级越高
public class validateAspect {

    // 可以使用前面写了的切入点表达式
    @Before("com.tcl.spring.aop.annotation.LogAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("validate --> 前置通知");
    }
}
