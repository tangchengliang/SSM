package com.tcl.spring.dao.impl;

import com.tcl.spring.dao.UserDao;

/**
 * @author tcl
 * @date 2022-08-02 15:09
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("保存成功");
    }
}
