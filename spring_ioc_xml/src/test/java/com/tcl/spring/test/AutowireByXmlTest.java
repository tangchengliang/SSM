package com.tcl.spring.test;

import com.tcl.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tcl
 * @date 2022-08-02 15:22
 */
public class AutowireByXmlTest {
    @Test
    public void testAutoWire(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
