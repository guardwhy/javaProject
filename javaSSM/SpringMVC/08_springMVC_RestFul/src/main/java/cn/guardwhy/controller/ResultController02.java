package cn.guardwhy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 转发和重定向
 */
@Controller
public class ResultController02 {
    @RequestMapping(value = "m1/t1")
    public String test1(Model model){
        // 转发方式
        model.addAttribute("{msg}", "ModelTest1");
        return "success";
    }

    @RequestMapping(value = "m1/t2")
    public String test2(Model model){
        // 转发方式
        model.addAttribute("{msg}", "ModelTest1");
        return "redirect:/index2.jsp";
    }
}
