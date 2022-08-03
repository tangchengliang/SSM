package com.tcl.spring.test;
import com.tcl.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @author tcl
 * @date 2022-08-01 15:31
 */
public class IOCByXmlTest {

    @Test
    public void testIOC(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        // id
        Student studentOne = (Student) ioc.getBean("studentOne");
        System.out.println(studentOne);
        // 类型
        Student s = ioc.getBean(Student.class);
        System.out.println(s);
        // id+类型
        Student student = ioc.getBean("studentOne", Student.class);
        System.out.println(student);
    }

}
