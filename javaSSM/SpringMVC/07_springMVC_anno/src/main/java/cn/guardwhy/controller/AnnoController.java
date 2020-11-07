package cn.guardwhy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
public class AnnoController {
    /***
     * 把请求中指定名称的参数给控制器中的形参赋值。
     * @param username
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("形参赋值...");
        System.out.println(username);
        return "success";
    }

    /***
     * 获取请求体的内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("获取请求体内容...");
        System.out.println(body);
        return "success";
    }

    /***
     * 用于绑定 url中的占位符
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("获取占位符...");
        System.out.println(id);
        return "success";
    }
}
