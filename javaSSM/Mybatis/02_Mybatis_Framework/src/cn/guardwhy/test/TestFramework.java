package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.User;
import cn.guardwhy.framework.Configuration;
import cn.guardwhy.framework.SqlSession;

import java.util.List;

public class TestFramework {
    public static void main(String[] args) {
        // 1.使用SqlSession类
        SqlSession session = new SqlSession();
        // 2.调用getMapper(UserMapper.class),返回的就是代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        System.out.println(userMapper.getClass());
        // 3.调用代理对象的方法,得到所有的用户
        List<User> users = userMapper.findAllUsers();
        // 4.输出user
        users.forEach(System.out::println);
    }
}
