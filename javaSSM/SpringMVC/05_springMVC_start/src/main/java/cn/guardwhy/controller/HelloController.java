package cn.guardwhy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 入门案列
 */
@Controller
public class HelloController {
    /**
     * 接收请求
     */
    @RequestMapping(path = "/h1")
    public String sayHello(){
        System.out.println("Hello SpringMVC!!!");
        return "success";
    }
}
