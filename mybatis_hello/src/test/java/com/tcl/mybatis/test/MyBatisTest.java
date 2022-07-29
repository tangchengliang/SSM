package com.tcl.mybatis.test;

import com.tcl.mybatis.mapper.UserMapper;
import com.tcl.mybatis.pojo.User;
import com.tcl.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author tcl
 * @date 2022-07-21 15:45
 */
public class MyBatisTest {

    @Test
    public void testInsert() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配
        // 映射文件中的SQL标签，并执行标签中的SQL语句

        int result = userMapper.insertUser();
        System.out.println("结果："+result);

        // 关闭
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        // 获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行sql语句
        mapper.updateUser();
        // 关闭
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        // 获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行sql语句
        mapper.deleteUser();
        // 关闭
        sqlSession.close();
    }

    // 查询语句 需要 结果映射
    @Test
    public void testGetUserById(){
        // 获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行sql语句
        User userById = mapper.getUserById();
        System.out.println(userById);
        // 关闭
        sqlSession.close();
    }

    // 查询语句 需要 结果映射
    @Test
    public void testGetAllUser(){
        // 获取sqlSession对象
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行sql语句
        List<User> allUser = mapper.getAllUser();
        for(User user: allUser){
            System.out.println(user);
        }
        // 关闭
        sqlSession.close();
    }
}
