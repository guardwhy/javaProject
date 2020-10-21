package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.QueryVo;
import cn.guardwhy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;

/**
 * 测试类
 */
public class TestUserDao {
    // 会话工厂
    private static SqlSessionFactory factory;
    // 会话
    private SqlSession session;
    // 接口
    private UserMapper userMapper;

    /**
     * 类加载的时候执行一次,创建会话工厂
     */
    @BeforeClass
    public static void init() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
    }

    /**
     * 每个测试方法前都会执行的方法
     */
    @Before
    public void begin(){
        session = factory.openSession();
        // 创建代理对象
        userMapper = session.getMapper(UserMapper.class);
    }

    //通过id查询1个用户
    @Test
    public void testFindUserById(){
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    // 通过名字模糊查询
    @Test
    public void testFindUserByName(){
        List<User> users = userMapper.findUsersByName("大");
        users.forEach(System.out::println);
    }


    // 添加1个用户, 在mybatis中增删改，默认是手动提交事务
    @Test
    public void testAddUser(){
        User user = new User(null, "樊勇", Date.valueOf("1975-03-10"),"男","江州");
        int row = userMapper.addUser(user);
        System.out.println("添加了" + row + "行");
        // 得到主键的值
        Integer id = user.getId();
        System.out.println("生成主键的值:" + id);
    }

    // 更新8号用户
    @Test
    public void testUpdateUser(){
        User user = new User(8, "田跃进", Date.valueOf("1976-05-10"), "男", "秦阳");
        int row = userMapper.updateUser(user);
        System.out.println("更新了" + row + "行");
    }

    // 删除用户
    @Test
    public void testDeleteUser(){
        int row = userMapper.deleteUser(12);
        System.out.println("删除了" + row + "行记录");
    }

    // POJO多条件查询
    @Test
    public void testFindUsersByCondition(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("大");
        queryVo.setUser(user);

        queryVo.setStart("1980-1-1");
        queryVo.setEnd("1993-1-1");
        List<User> userList = userMapper.findUsersByCondition(queryVo);
        userList.forEach(System.out::println);
    }

    // 统计用户表某种性别的数量
    @Test
    public void testGetAmountBySex(){
        int amount = userMapper.getAmountBySex("女");
        System.out.println("女生的数量:" + amount);
    }

    //通过id查询1个用户
    @Test
    public void testFindUser2ById(){
        User user = userMapper.findUser2ById(1);
        System.out.println(user);
    }

    // 用完后关闭会话
    @After
    public void end(){
        session.commit();
        session.close();
    }
}
