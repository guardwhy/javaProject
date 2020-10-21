package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.User;
import cn.guardwhy.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestUserDao {
    // 1.会话
    private SqlSession session;
    // 2.接口
    private UserMapper userMapper;

    // 3.每个测试方法执行前都会执行
    @Before
    public void begin(){
        session = SessionFactoryUtils.getSession();
        // 创建代理对象
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void testFindUserByNameAndSex(){
        User user = new User();
        user.setUsername("大");
        user.setSex("男");
        // 将元素添加到集合中
        List<User> userList = userMapper.findUserByNameAndSex(user);
        userList.forEach(System.out::println);
    }

    // 更新操作
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setUsername("宁玲");
        user.setSex("女");
        user.setId(8);
        // 更新行数
        int row = userMapper.updateUser(user);
        System.out.println("更新了" + row + "行");
    }

    // 添加批量元素
    @Test
    public void testAddUsers(){
        // 创建集合对象
        List<User> users = new ArrayList<>();
        users.add(new User(null,"王大辉", Date.valueOf("1988-01-30"),"男","岭西"));
        users.add(new User(null,"侯国龙", Date.valueOf("1975-05-08"),"男","江州"));
        users.add(new User(null,"杨红英", Date.valueOf("1993-11-01"),"女","江州"));
        int i = userMapper.addUsers(users);
        System.out.println("添加了" + i + "行");
    }

    // 删除多个用户
    @Test
    public void testDeleteUsers(){
        // 定义数组
        int[] ids = {3,6,9};
        int i = userMapper.deleteUsers(ids);
        System.out.println("删除了" + i + "行");
    }

    // 根据条件查询用户
    @Test
    public void testFindUserByCondition(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "候");
        map.put("minDate","1980-1-1");
        map.put("maxDate","1993-12-1");
        List<User> userList = userMapper.findUserByCondition(map);
        // 遍历集合
        userList.forEach(System.out::println);
    }

    // 根据条件查询用户的个数
    @Test
    public void testFindUserCount(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "候");
        map.put("minDate","1980-1-1");
        map.put("maxDate","1993-12-1");
        int count = userMapper.findUserCount(map);
        // 输出个数
        System.out.println("共有用户" + count + "个");
    }

    // 最后操作,用完后关闭会话
    @After
    public void end(){
        // 手动提交
        session.commit();
        session.close();
    }
}
