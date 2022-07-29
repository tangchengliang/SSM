package com.tcl.mybatis.mapper;

import com.tcl.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    // 查询用户的总数
    Integer getCount();

    // 没有具体的返回值，使用map记录
    Map<String, Object> getUserToMap(@Param("id") Integer id);

    // 查询所有用户信息，返回一个Map
    List<Map<String ,Object>> getAllUserTOMapList();

    // 通过 名称，模糊查询
    List<Map<String ,Object>> getUserByLike(@Param("mohu") String mohu);

    // 批量删除数据
    void deleteByIds(@Param("ids") String ids);

    // 动态设置表名，查询用户信息
    List<User> getUserList(@Param("tableName") String tableName);

    // 添加时获取主键
    void insertUser(User user);
}
