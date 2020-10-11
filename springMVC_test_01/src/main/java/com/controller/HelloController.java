package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//控制器类
@Controller
public class HelloController {

    /**
     * 入门案例
     * /user/hello      一级目录和二级目录
     * @RequestMapping 可以写在类上
     * @return
     */
    @RequestMapping(path = "/hello", method = {RequestMethod.GET} )
    public String sayHello(){
        System.out.println("入门成功");
        return "success";
    }
}
