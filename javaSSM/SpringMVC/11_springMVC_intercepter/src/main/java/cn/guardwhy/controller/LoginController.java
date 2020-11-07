package cn.guardwhy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    /***
     * 登录成功页面
     * @param username
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String pwd, HttpSession session, Model model){
        // 1.1 像session记录用户身份信息
        System.out.println("接收前端===" + username);
        // 1.2 将用户的登录信息存放在session中
        session.setAttribute("userLoginInfo", username);
        // 1.3 添加username传给页面
        model.addAttribute("username", username);
        // 1.3 返回该页面
        return "success";
    }

    /***
     * 直接跳转到登录页面
     * @return
     */
    @RequestMapping("/jumpLogin")
    public String login(){
        // 返回登录页面
        return "login";
    }

    /***
     * 直接跳转到登录成功页面
     * @return
     */
    @RequestMapping("/success")
    public String success(){
        // 直接跳转到登录成功页面
        return "success";
    }

    /***
     * 退出登陆页面
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        // session 过期
        session.removeAttribute("userLoginInfo");
        // 返回登录页面
        return "login";
    }

}
