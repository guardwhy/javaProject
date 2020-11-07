package cn.guardwhy.controller;

import cn.guardwhy.domain.User;
import cn.guardwhy.utils.JsonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @Controller
@RestController // 不走视图解析器
public class UserController {
    /***
     * 返回JSON字符串
     * @return
     */
    @RequestMapping("/json1")
    @ResponseBody   // 该注解不会走视图解析器,会直接返回一个字符串
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // 1.创建一个user对象
        User user = new User("guardwhy", 26, "男");
        //2. 将Java对象转换为json字符串
        String str = mapper.writeValueAsString(user);
        // 3.返回JSON字符串
        return str;
    }

    /***
     * 集合输出
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/json2")
    @ResponseBody
    public String json2() throws JsonProcessingException {
        // 1.创建list集合
        List<User> list1 = new ArrayList<>();
        // 2.给User对象添加属性
        User user1 = new User("kobe", 41, "男");
        User user2 = new User("James", 35, "男");
        User user3 = new User("Curry", 10, "男");
        // 3.将对象添加到集合中
        list1.add(user1);
        list1.add(user2);
        list1.add(user3);

        // 4.返回集合
        return new ObjectMapper().writeValueAsString(list1);
    }

    /***
     * 输出时间对象
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/json3")
    @ResponseBody
    public String json3() throws JsonProcessingException {
        // 1.创建时间对象
        Date date = new Date();
        // 2.得到json时间对象
        String json = JsonUtils.getJson(date);
        // 3.返回JSON时间对象
        return json;
    }

    /***
     * fastjson
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/json4")
    @ResponseBody
    public String json4() throws JsonProcessingException {
        // 1.创建list2集合
        List<User> list2 = new ArrayList<>();
        // 2.给User对象添加属性
        User user1 = new User("kobe", 41, "男");
        User user2 = new User("yaoMing", 42, "男");
        User user3 = new User("Curry", 10, "男");
        // 3.将对象添加到集合中
        list2.add(user1);
        list2.add(user2);
        list2.add(user3);
        // 4.将集合对象转成JSON字符串
        String str = JSON.toJSONString(list2);

        // return "str";

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list2);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return "Hello";
    }
}
