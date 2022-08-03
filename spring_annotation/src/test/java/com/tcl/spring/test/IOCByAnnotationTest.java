package com.tcl.spring.test;

import com.tcl.spring.controller.UserController;
import com.tcl.spring.dao.UserDao;
import com.tcl.spring.service.UserService;
import com.tcl.spring.service.iml.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tcl
 * @date 2022-08-02 16:13
 */
public class IOCByAnnotationTest {

    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController controller = ioc.getBean("userController",UserController.class);
        System.out.println(controller);

        UserService service = ioc.getBean(UserService.class);
        System.out.println(service);

        UserDao dao = ioc.getBean("userDaoImpl",UserDao.class);
        System.out.println(dao);
    }
}
