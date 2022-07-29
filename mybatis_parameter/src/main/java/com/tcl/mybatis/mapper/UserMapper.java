package com.tcl.mybatis.mapper;

import com.tcl.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {

    // 通过用户名，获取User
    User getUserByName(String name);

    /**
     *
     * @author tcl
     * @date 2022/7/27 16:13
     * @param name
     * @param password
     * @return com.tcl.mybatis.pojo.User
     */
    User checkLogin(String name, String password);

    // 通过map自定义创建Map集合
    User checkLoginByMap(Map<String, Object> map);

    // 插入一个user对象
    void insertUser(User user);

    //通过注解 检查登录
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
