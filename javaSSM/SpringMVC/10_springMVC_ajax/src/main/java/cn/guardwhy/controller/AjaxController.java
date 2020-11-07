package cn.guardwhy.controller;

import cn.guardwhy.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    /***
     * 判断用户名是否存在
     * @param name
     * @param response
     * @throws IOException
     */
    @RequestMapping("/ajax1")
    public void ajax1(String name, HttpServletResponse response) throws IOException {
        // 1.条件判断
        if("guardwhy".equals(name)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }

    /***
     * 返回集合数据
     * @return
     */
    @RequestMapping("/ajax2")
    public List<User> ajax2() {
        // 1.创建list集合
        List<User> list = new ArrayList<User>();
        // 2.将对象添加到集合中
        list.add(new User("kobe", 41, "男"));
        list.add(new User("James", 35, "男"));
        list.add(new User("Curry", 10, "男"));

        // 3.将集合转换成JSON格式返回
        return list;
    }

    /***
     * 用户登录案例
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/ajax3")
    public String ajax3(String name, String pwd){
        // 1.定义str字符串
        String str = "";
        // 2.判断用户名是否正确
        if(name != null){
            if("guardwhy".equals(name)){
                str = "ok";
            }else {
                str = "用户名错误";
            }
        }
        // 3.判断密码是否正确
        if(pwd != null){
            if("123".equals(pwd)){
                str = "ok";
            }else {
                str = "密码错误";
            }
        }

        // 4.将str转换成JSON格式返回
        return str;
    }
}
