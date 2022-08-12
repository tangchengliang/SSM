package com.tcl.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 指定当前测试类在Spring的测试环境中执行
// 此时，可以通过注入的方式直接获取IOC容器中bean
@RunWith(SpringJUnit4ClassRunner.class)
// 设置Spring测试环境文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTempleTest {

    // 自动装配
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql, "root","123",23,"女","123.@qq.com");
    }
}
