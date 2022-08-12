package com.tcl.spring.test;

import com.tcl.spring.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void testAopAnnotation(){
        // 1.获取IOC容器（在IOC容器基础上实现）
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        // 不能从ioc容器中获取目标对象，只能获取代理对象
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(1,1);
    }
}
