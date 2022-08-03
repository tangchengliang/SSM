package com.tcl.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Stack;

/**
 * @author tcl
 * @date 2022-08-01 17:31
 */
public class DataSourceTest {

    @Test
    public void dataSourceTest() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-datasourse.xml");
        DruidDataSource dataSource = ioc.getBean("dataSource",DruidDataSource.class);
        System.out.println(dataSource.getConnection());
        Stack<Integer> stack = new Stack<Integer>();

    }
}
