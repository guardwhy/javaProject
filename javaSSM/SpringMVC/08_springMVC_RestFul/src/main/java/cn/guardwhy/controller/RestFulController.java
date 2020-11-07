package cn.guardwhy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * RestFul风格入门案例
 */
@Controller
public class RestFulController {
    // 1.访问映射路径
    @RequestMapping(value = "/commit/{a}/{b}", method = RequestMethod.GET)
    public String test1(@PathVariable int a, @PathVariable String b, Model model){
        // 返回结果集
        String res = a + b;
        model.addAttribute("msg", "结果返回值1:" + res);
        return "success";
    }

    // post方法
    @PostMapping("/commit/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable String b, Model model){
        // 返回结果集
        String res = a + b;
        model.addAttribute("msg", "结果返回值2:" + res);
        return "success";
    }
}
