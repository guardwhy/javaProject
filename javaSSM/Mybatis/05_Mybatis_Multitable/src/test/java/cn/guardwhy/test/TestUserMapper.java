package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.OrderForm;
import cn.guardwhy.domain.Role;
import cn.guardwhy.domain.User;
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

    // 2.测试代码
    @Test
    public void testFindUserAndInfo(){
        User user = userMapper.findUserAndInfo(1);
        System.out.println("用户信息:" + user);
        System.out.println("扩展信息:" + user.getUserInfo());
    }

    // 3.查询1号用户的所有订单
    @Test
    public void testFindUserAndOrders(){
        User user = userMapper.findUserAndOrders(1);
        System.out.println("用户信息:" + user);
        List<OrderForm> orders = user.getOrders();
        System.out.println("用户订单信息如下:" );
        for (OrderForm order : orders){
            System.out.println(order);
        }
    }

    // 多对多关联查询
    @Test
    public void testFindRolesByUserId(){
        User user = userMapper.findRolesByUserId(1);
        System.out.println("用户信息:" + user);
        List<Role> roles = user.getRoles();
        System.out.println("用户角色如下: ");
        for(Role role : roles){
            System.out.println(role);
        }
    }
    // 3.关闭会话
    @After
    public void end(){
        // 手动提交
        session.commit();
        session.close();
    }
}
