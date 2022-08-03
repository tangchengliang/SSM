package com.tcl.spring.factory;

import com.tcl.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author tcl
 * @date 2022-08-02 15:05
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
