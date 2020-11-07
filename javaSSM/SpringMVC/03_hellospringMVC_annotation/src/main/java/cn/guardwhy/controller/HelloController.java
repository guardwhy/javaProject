package cn.guardwhy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springMVC入门原理案例(注解版本)
 */
@Controller
public class HelloController {
    //真实访问地址 : 项目名/success
    @RequestMapping("/success")
    public String sayHello(Model model){
        // 1.向模型中添加属性，可以在页面中取出渲染
        model.addAttribute("msg", "hello, SpringMVC");
        //2. web-inf/jsp/success.jsp
        return "success";
    }
}
