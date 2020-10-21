package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.OrderForm;
import cn.guardwhy.domain.User;
import cn.guardwhy.domain.UserInfo;
import cn.guardwhy.utils.SessionFactoryUtils;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
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

    // 一对一关联查询
    @Test
    public void testFindUserById(){
        User user = userMapper.findUserById(1);
        System.out.println("用户名:" + user.getUsername());
        /*UserInfo userInfo = user.getUserInfo();
        System.out.println(userInfo);*/

        // 1对多
        List<OrderForm> orders = user.getOrders();
        orders.forEach(System.out::println);
    }

    /**
     * 1、第一次查询以后，提交会话
     * 2、再进行第二次查询，观察查询结果
     */
    @Test
    public void testFirstLevelCache(){
        // 1.打开会话
        session = SessionFactoryUtils.getSession();
        //2.在同一个会话中查询2次，观察SQL语句生成次数
        userMapper = session.getMapper(UserMapper.class);
        // 3.得到用户拓展信息
        UserInfo userInfo1 = userMapper.findUserInfoById(1);
        System.out.println(userInfo1);

       session.commit(); // 提交,清空1级缓存

       // 第二次查询: 使用缓存
        UserInfo userInfo2 = userMapper.findUserInfoById(1);
        System.out.println(userInfo2);
    }

    // 关闭会话
    @After
    public void end(){
        session.close();
    }
}
