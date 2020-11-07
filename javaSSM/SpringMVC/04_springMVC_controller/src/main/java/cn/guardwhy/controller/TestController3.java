package cn.guardwhy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guardwhy")
public class TestController3 {
    @RequestMapping("/test3")

    public String Test3(Model model){
        // 自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "ControllerTest3");
        return "test";
    }
}
