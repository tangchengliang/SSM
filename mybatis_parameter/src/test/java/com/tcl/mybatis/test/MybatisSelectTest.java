package com.tcl.mybatis.test;

import com.tcl.mybatis.mapper.SelectMapper;
import com.tcl.mybatis.pojo.User;
import com.tcl.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author tcl
 * @date 2022-07-27 17:35
 */
public class MybatisSelectTest {

    @Test
    public void checkGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void getUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserToMap(5);
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void getAllUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> listMap = mapper.getAllUserTOMapList();
        System.out.println(listMap);
        sqlSession.close();
    }

    @Test
    public void getUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> list = mapper.getUserByLike("a");
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        mapper.deleteByIds("5,6");
        sqlSession.close();
    }

    @Test
    public void getUserByTableName(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> t_user = mapper.getUserList("t_user");
        t_user.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void getInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = new User(null,"hello", "sasd",23,"女", "sdasdasff");
        mapper.insertUser(user);
        System.out.println(user);
        sqlSession.close();
    }
}
