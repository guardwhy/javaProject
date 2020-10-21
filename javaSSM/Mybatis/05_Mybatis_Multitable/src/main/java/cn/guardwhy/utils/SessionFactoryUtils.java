package cn.guardwhy.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 会话工厂工具类
 * 1.通过静态方法得到一个工厂对象
 * 2.通过静态方法得到会话对象
 */
public class SessionFactoryUtils {
    // 1.声明一个工厂对象
    private static SqlSessionFactory factory;
    // 2.在静态代码块中创建会话工厂
    static {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3.得到输入流
        try(InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");){
            factory = builder.build(inputStream);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    // 3.静态方法得到会话工厂
    public static SqlSessionFactory getSessionFactory(){
        return factory;
    }

    // 4.得到会话对象
    public static SqlSession getSession(){
        return factory.openSession();
    }
}
