package cn.guardwhy.framework;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 会话类
 */
public class SqlSession {
    /**
     * 创建UserMapper接口的代理对象
     * @param mapperClass 接口类对象
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> mapperClass){
        return (T) Proxy.newProxyInstance(SqlSession.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            /***
             *
             * @param proxy 生成的代理对象
             * @param method   要调用的方法
             * @param args 方法的参数
             * @return 返回值:方法的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 1.创建Configuration对象
                Configuration configuration = new Configuration();
                // 2.得到方法的名字
                String id = method.getName();
                // 3.得到接口的名字
                String namespace = method.getDeclaringClass().getName();
                // 4.得到key值
                String key = namespace + "." + id;
                // 5.得到值
                Map<String, Mapper> mappers = configuration.getMappers();
                Mapper mapper = mappers.get(key);
                // 6.SQL语句
                String sql = mapper.getSql();
                // 7.得到返回数据类型
                String resultType = mapper.getResultType();
                // 8.得到它的类对象
                Class objClass = Class.forName(resultType);
                // 9.访问数据库需要Connection对象
                DataSource dataSource = configuration.getDataSource();
                Connection connection = dataSource.getConnection();

                // 使用JDBC来访问数据库,并且封装成List<User>
                List list = queryForList(connection, sql, objClass);
                return list;
            }
        });
    }

    /**
    使用JDBC来访问数据库，并且封装成List<User>
     */
    private List queryForList(Connection connection, String sql, Class clazz) throws Exception{
        List users = new ArrayList<>();
        // 1.通过连接对象得到预编译的语句对象
        PreparedStatement ps = connection.prepareStatement(sql);
        // 2.执行SQL语句,得到结果集
        ResultSet rs = ps.executeQuery();
        // 3.遍历结果集,将每一行记录封装成一个User对象
        while (rs.next()){
            Object user = clazz.getConstructor().newInstance();
            // 得到类中的所有成员变量
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields){
                // 得到成员变量的名字
                String name = field.getName();
                // 遍历成员变量给每个成员变量赋值
                field.setAccessible(true);
                // 从结果集取出所有的数据
                field.set(user, rs.getObject(name));
            }
            // 4.添加到集合中
            users.add(user);
        }

        rs.close();
        ps.close();
        connection.close();
        // 5.返回集合
        return users;
    }
}
