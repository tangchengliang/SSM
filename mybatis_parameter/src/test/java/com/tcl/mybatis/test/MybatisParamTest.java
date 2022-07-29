package com.tcl.mybatis.test;

import com.tcl.mybatis.mapper.SelectMapper;
import com.tcl.mybatis.mapper.UserMapper;
import com.tcl.mybatis.pojo.User;
import com.tcl.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tcl
 * @date 2022-07-27 15:48
 */
public class MybatisParamTest {

    @Test
    public void getUserByName(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByName("admin");
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void getCheckLoginUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("admin", "123456");
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void getCheckLoginUserByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "admin");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "root", "123456", 23, "女", "sadas@qq.com");
        mapper.insertUser(user);

        sqlSession.close();
    }

    @Test
    public void checkLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("root", "123456");
        System.out.println(user);
        sqlSession.close();
    }


}
