package cn.guardwhy.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller详解
 */
public class TestController1 implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        // 1.返回一个模型视图对象
        ModelAndView mv = new ModelAndView();
        // 2.封装对象，放在ModelAndView中。
        mv.addObject("msg", "TestController1");
        // 3. 封装跳转的视图
        mv.setViewName("test");
        return mv;
    }
}
