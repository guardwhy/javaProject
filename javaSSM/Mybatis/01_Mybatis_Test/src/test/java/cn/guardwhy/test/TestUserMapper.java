package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.enty.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 使用mybatis数据库
 */
public class TestUserMapper {
    public static void main(String[] args) throws IOException {
        // 1.得到输入流对象
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 2.创建会话工厂建造类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3.通过建造类创建会话工厂
        SqlSessionFactory factory = builder.build(inputStream);
        // 4.通过会话工厂得到会话对象
        SqlSession session = factory.openSession();
        // 5.会话对象的得到UserMapper接口代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 6.生成了代理对象
        System.out.println(userMapper);
        // 7.执行查询操作
        List<User> users = userMapper.findAllUsers();
        // 8.遍历
        users.forEach(System.out::println);
        // 9.关闭会话
        session.close();
    }
}
