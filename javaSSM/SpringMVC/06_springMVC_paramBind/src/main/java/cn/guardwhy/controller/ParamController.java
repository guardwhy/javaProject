package cn.guardwhy.controller;

import cn.guardwhy.domian.Account;
import cn.guardwhy.domian.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求参数绑定
*/
@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数绑定入门案例
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username, String password){
        System.out.println("执行了该方法");
        System.out.println("用户名:" + username);
        System.out.println("用户密码:" + password);
        return "success";
    }

    /***
     * 将参数绑定的数据封装到javaBean的类中
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("执行了该方法");
        System.out.println(account);
        return "success";
    }

    /***
     * 自定义转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("执行了该方法");
        System.out.println(user);
        return "success";
    }
}
