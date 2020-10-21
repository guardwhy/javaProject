package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
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

    // 1.创建会话对象,自动提交事务
    @Before
    public void begin(){
        session = SessionFactoryUtils.getSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    /**
     * 1、在同一个测试方法中查询2次
     * 2、输出用户信息
     */
    @Test
    public void testFirstLevelCache1(){
        // 1.打开会话
        session = SessionFactoryUtils.getSession();
        //2.在同一个会话中查询2次，观察SQL语句生成次数
        userMapper = session.getMapper(UserMapper.class);
        // 3.得到用户拓展信息
        UserInfo userInfo1 = userMapper.findUserInfoById(1);
        System.out.println(userInfo1);

        // 4.第二次查询: 使用缓存
        UserInfo userInfo2 = userMapper.findUserInfoById(1);
        System.out.println(userInfo2);
    }

    /**
     * 1、第一次查询以后，提交会话
     * 2、再进行第二次查询，观察查询结果
     */
    @Test
    public void testFirstLevelCache2(){
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

    @Test
    /**
     * 1. 创建一个会话查询1条记录，关闭会话
     * 2. 再创建一个会话查询1条记录，关闭会话
     */
    public void testFirstLevelCache3(){
        // 1.创建第一个会话
        SqlSession session1 = SessionFactoryUtils.getSession();
        UserMapper userMapper1 = session.getMapper(UserMapper.class);
        // 2.得到所有用户拓展信息
        List<UserInfo> userInfos1 = userMapper1.findAllUserInfo();
        // 2.遍历操作
        userInfos1.forEach(System.out::println);
        // 3.关闭会话
        session1.close();

        // 1.创建第一个会话
        SqlSession session2 = SessionFactoryUtils.getSession();
        UserMapper userMapper2 = session.getMapper(UserMapper.class);
        // 2.得到所有用户拓展信息
        List<UserInfo> userInfos2 = userMapper2.findAllUserInfo();
        // 2.遍历操作
        userInfos2.forEach(System.out::println);
        // 3.关闭会话
        session2.close();
    }

    // 3.关闭会话
    @After
    public void end(){
        // session.close();
    }
}
