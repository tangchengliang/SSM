package com.tcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @RequestMapping 标识一个类：设置映射请求的请求路径的初始信息:
 * @RequestMapping 标识一个方法：设置映射请求请求路径的具体信息:
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController {

    // 此时控制器方法匹配的请求路径为 /test/hello,
    // 因此需要在浏览器上手动添加/test
    @RequestMapping(
            value = {"/hello", "/haa"},
            method = {RequestMethod.GET, RequestMethod.DELETE} )
    public String hello(){
        return "success";
    }

    @RequestMapping(value = {"/a?a/hello","/a*a/hellos","/hello/**/"})
    public String hello1(){
        return "success";
    }
}
