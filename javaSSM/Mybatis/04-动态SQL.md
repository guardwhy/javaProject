## 环境搭建

### 项目目录

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/24-Mybatis.png)

### 会话工厂的工具类

1. 在静态代码块中创建会话工厂
2. 编写静态方法得到会话
3. 编写静态方法得到会话工厂

```java
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
        // 得到输入流
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
```

## 通过用户和性别查询数据

### 声明Mapper接口方法

```java
package cn.guardwhy.dao;

import cn.guardwhy.domain.User;

import java.util.List;

/**
 * 用户dao的接口
 */
public interface UserMapper {
    // 1.根据用户名称和性别查询用户
    List<User> findUserByNameAndSex(User user);
}
```

### 配置mappr映射文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 实体类的映射文件namespace 指定接口的类全名 -->
<mapper namespace="cn.guardwhy.dao.UserMapper">
    <!--1.多条件查询-->
    <select id="findUserByNameAndSex" resultType="user" parameterType="user">
        select * from user where username like '%${username}%' and sex = #{sex}
    </select>
</mapper>
```

### 测试代码

@Test测试方法中通过用户名和性别查询多个用户，查询条件是"大"和"男"

```java
package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.User;
import cn.guardwhy.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    // 最后操作,用完后关闭会话
    @After
    public void end(){
        // 手动提交
        session.commit();
        session.close();
    }
}
```

### 执行效果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/25-Mybatis.png)

## IF标签

```properties
作用：判断条件是否为真，如果为真则将if中字符串接近到SQL语句中
```

### 配置mappr映射文件

1. 根据用户名称和性别查询用户
2. if：判断用户名称不为空，且不为空字符串，则作为查询条件
3. if：判断用户性别不为空，且不为空字符串，则作为查询条件

```xml
<!--1.多条件查询-->
<select id="findUserByNameAndSex" resultType="user" parameterType="user">
    select * from user where
    <!-- 如果username不为空，而且不为空字符串，则做为查询的条件-->
    <if test="username!=null and username!=''">
        username like '%${username}%'
    </if>
    <if test="sex!=null and sex!=''">
        and sex= #{sex}
    </if>
</select>
```

## Where标签

```properties
作用：
1. where标签就相当于SQL语句中where关键字
2. 去掉多余的and,or,where关键字
```

### 配置mappr映射文件

1. 根据用户名称和性别查询用户
2. if标签写在where标签内部
   1. if：判断用户名称不为空，且不为空字符串，则作为查询条件
   2. if：判断用户性别不为空，且不为空字符串，则作为查询条件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 实体类的映射文件namespace 指定接口的类全名 -->
<mapper namespace="cn.guardwhy.dao.UserMapper">
    <!--1.多条件查询-->
    <select id="findUserByNameAndSex" resultType="user" parameterType="user">
        select * from user
        <where>
            <!-- 如果username不为空，而且不为空字符串，则做为查询的条件-->
            <if test="username!=null and username!=''">
                username like '%${username}%'
            </if>
            <if test="sex!=null and sex!=''">
                and sex= #{sex}
            </if>
        </where>

    </select>
</mapper>
```

### 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/25-Mybatis.png)

## Set标签

作用:更新用户信息的时候,有些表单项为空则不用更新。

```properties
1. 用在update这个语句，相当于set关键字
2. 与if标签配合使用，对有值的字段进行更新
3. 可以去掉多余的逗号
```

### 声明Mapper接口方法

```java
// 2.更新用户
int updateUser(User user);
```

### 配置mappr映射文件

通过id来更新用户名或性别

1. update标签更新用户数据
2. 如果username不为空而且不为空串，则更新
3. 如果sex不为空而且不为空串，则更新
4. 最后加上where条件

```xml
<!--更新操作-->
<update id="updateUser" parameterType="user">
   update user
    <set>
        <if test="username!=null and username!=''">
            username = #{username},
        </if>
        <if test="sex!=null and sex!=''">
            sex=#{sex}
        </if>
    </set>
    where id=#{id}
</update>
```

### 测试代码

```java
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
```

### 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/26-Mybatis.png)

## Foreach标签

### 参数类型是集合

```properties
作用:拼接SQL语句，中间用到循环,有一段SQL语句出现多次。
```

#### 声明Mapper接口方法

```java
// 3.批量添加用户
int addUsers(List<User> users);
```

#### 配置mapper映射文件

```properties
批量新增用户，参数类型是：list
```

| foreach标签的属性 | 作用                                   |
| ----------------- | -------------------------------------- |
| collection        | 两个取值：list 表示集合 array 表示数组 |
| item              | 集合中每个变量名字                     |
| separator         | 每次遍历后添加分隔符                   |
| \#{变量名.属性}   | 引用每个属性                           |

```xml
<!--批量添加用户-->
<insert id="addUsers" parameterType="list">
    insert into user values
    <!--
        collection:两个取值：list 表示集合 array 表示数组
        item:集合中每个变量名字
        separator:每次遍历后添加分隔符
        -->
    <foreach collection="list" item="user" separator=",">
        (null,#{user.username},#{user.birthday}, #{user.sex}, #{user.address})
    </foreach>
</insert>
```

#### 测试代码

```java
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
```

#### 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/27-Mybatis.png)

### 参数类型是数组

#### 声明mapper接口方法

```java
// 4.批量删除用户
int deleteUsers(int[] ids);
```

#### 配置mapper映射文件

parameterType 因为内置别名中没有数组类型的参数，所以当参数传递的是list和数组，都写成list

```xml
<!--批量删除用户-->
<delete id="deleteUsers" parameterType="list">
    delete from user where id in
    <foreach collection="array" open="(" item="id" separator="," close=")">
        #{id}
    </foreach>
</delete>
```

#### 测试代码

1. 删除多个用户
2. 返回影响的行数

```java
// 删除多个用户
@Test
public void testDeleteUsers(){
    // 定义数组
    int[] ids = {3,6,9};
    int i = userMapper.deleteUsers(ids);
    System.out.println("删除了" + i + "行");
}
```

#### 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/28-Mybatis.png)

## Sql和include标签

**作用**：

```properties
sql标签：定义一段可以重用的SQL语句
include标签： 引用上面定义的SQL语句
```

### 声明mapper接口方法

```java
 // 5.根据条件查询多个用户
List<User> findUserByCondition(Map<String, Object> condition);

// 6.根据条件查询有多少用户
int findUserCount(Map<String, Object> condition);
```

### 配置mapper映射文件

```xml
<!--定义一个可以重用的代码块-->
<sql id="conditionSql">
    <where>
        <if test="username!=null and username!=''">
            username like '%${username}%'
        </if>
        <if test="minDate!=null and minDate!=''">
            and birthday &gt;= #{minDate}
        </if>
        <if test="maxDate!=null and maxDate!=''">
            and birthday &lt;= #{maxDate}
        </if>
    </where>
</sql>

<!--
    根据条件查询多个用户 map有三个键：username, minDate, maxDate
    -->
<select id="findUserByCondition" parameterType="map" resultType="user">
    select * from user
    <!-- 引用以上代码块-->
    <include refid="conditionSql"/>
</select>

<select id="findUserCount" parameterType="map" resultType="int">
    select count(*) from user
    <!-- 引用以上代码块-->
    <include refid="conditionSql"></include>
</select>
```

### 测试代码

```java
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
```

### 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/29-Mybatis.png)