package com.tcl.spring.service.impl;

import com.tcl.spring.dao.UserDao;
import com.tcl.spring.service.UserService;

/**
 * @author tcl
 * @date 2022-08-02 15:08
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
