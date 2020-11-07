package cn.guardwhy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注解形式
 */
@Controller
public class TestController2 {
    // 映射访问路径
    @RequestMapping("/test2")
    public String Test2(Model model){
        // 自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "ControllerTest2");
        return "test";
    }
}
