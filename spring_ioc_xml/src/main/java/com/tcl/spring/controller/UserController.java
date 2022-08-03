package com.tcl.spring.controller;

import com.tcl.spring.pojo.User;
import com.tcl.spring.service.UserService;
import com.tcl.spring.service.impl.UserServiceImpl;

/**
 * @author tcl
 * @date 2022-08-02 15:03
 */
public class UserController {

    // 原来的方法，写死了的，不利于修改和维护
//    UserService userService = new UserServiceImpl();

    // 通过依赖注入
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
