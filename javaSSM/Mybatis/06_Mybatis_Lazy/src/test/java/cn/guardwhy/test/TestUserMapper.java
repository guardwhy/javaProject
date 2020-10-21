package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.OrderForm;
import cn.guardwhy.domain.User;
import cn.guardwhy.domain.UserInfo;
import cn.guardwhy.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestUserMapper {
    private static SqlSessionFactory factory;
    private SqlSession session;
    private UserMapper userMapper;

    // 创建会话对象,自动提交事务
    @Before
    public void begin(){
        session = SessionFactoryUtils.getSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void testFindUserAndInfo(){
        User user = userMapper.findUserById(1);
        System.out.println("用户信息:" + user);

        UserInfo info = userMapper.findUserInfoById(1);
        System.out.println("用户拓展信息:" + info);
    }

    @Test
    public void testFindUserById(){
        User user = userMapper.findUserById(1);
        System.out.println("用户名:" + user.getUsername() + ", 性别:" + user.getSex());
        // 需要用户的拓展信息
        UserInfo userInfo = user.getUserInfo();
        System.out.println("身高:" + userInfo.getHeight() + ", 体重:" + userInfo.getWeight());
    }

    @Test
    public void testFindUserById2(){
        User user = userMapper.findUserById(1);
        System.out.println("用户名:" + user.getUsername() + ", 性别:" + user.getSex());
        // 使用订单信息
        List<OrderForm> orders = user.getOrders();
        orders.forEach(System.out::println);
    }

    // 关闭会话
    @After
    public void end(){
        // 手动提交
        session.commit();
        session.close();
    }
}
