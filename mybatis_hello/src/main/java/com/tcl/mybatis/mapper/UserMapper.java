package com.tcl.mybatis.mapper;

import com.tcl.mybatis.pojo.User;

import java.util.List;

/**
 * @author tcl
 * @date 2022-07-21 15:35
 */
public interface UserMapper {
    // MyBatis中的mapper接口相当于以前的dao。但是区别在于，mapper仅仅是接口，我们不需要提供实现类。
    int insertUser();

    // 修改用户信息
    void updateUser();

    // 删除用户
    void deleteUser();

    // 查询用户，比较难，要转换为实体对象
    /**
     *
     * @author tcl
     * @date 2022/7/21 17:15
     * @return com.tcl.mybatis.pojo.User
     */
    User getUserById();

    /**
     * 查询所有用户的信息
     * @author tcl
     * @date 2022/7/21 17:26
     * @return java.util.List<com.tcl.mybatis.pojo.User>
     */
    List<User> getAllUser();
}
