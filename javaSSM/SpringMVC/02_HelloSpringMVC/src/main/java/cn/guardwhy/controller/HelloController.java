package cn.guardwhy.controller;
/**
 * springMVC入门原理案例
 */
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1. 创建ModelAndView模型和视图
        ModelAndView mv = new ModelAndView();

        //2. 封装对象，放在ModelAndView中。
        mv.addObject("msg","HelloSpringMVC!");

        //3.封装要跳转的视图，放在ModelAndView中.
        mv.setViewName("success"); // /WEB-INF/jsp/success.jsp
        return mv;
    }
}

