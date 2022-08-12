package com.tcl.spring.aop.annotation;

import org.springframework.stereotype.Component;


// 既不是控制层，也不是业务层，也不是持久层，因此 注解 用 @Component
@Component
public class CalculatorImpl implements Calculator{
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        return result;

    }

    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部 result = " + result);
        return result;

    }

    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        return result;


    }
}
