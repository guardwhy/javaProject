## 搭建项目环境

### 表结构和数据

```mysql
-- 创建数据库
create database mybatis
-- 创建user表
create table user (
  id int primary key auto_increment,
  username varchar(20) not null,
  birthday date,
  sex char(1) default '男',
  address varchar(50)
);

insert into user values (null, '侯大利','1980-10-24','男','江州');
insert into user values (null, '田甜','1992-11-12','女','阳州');
insert into user values (null, '王永强','1983-05-20','男','阳州');
insert into user values (null, '杨红','1995-03-22','女','秦阳');
```

### 项目目录

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/17-Mybatis.png)

### 创建工程,加入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cn.guardwhy</groupId>
    <artifactId>03_Mybatis_CRUD</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <!--倒入项目所需依赖-->
    <dependencies>
        <!--mybatis依赖-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.0</version>
        </dependency>
        <!--mysql连接依赖-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.37</version>
        </dependency>
        <!--日志依赖-->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <!--测试依赖-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
    </dependencies>
</project>
```

### sqlMapConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <environments default="default">
        <!--环境变量-->
        <environment id="default">
            <!--事务管理器：由JDBC管理事务 -->
            <transactionManager type="JDBC"/>
            <!--数据源配置信息：POOLED 使用连接池 -->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis"/>
                <property name="username" value="root"/>
                <property name="password" value="root"/>
            </dataSource>
        </environment>
    </environments>

    <!-- 加载其他的映射文件 -->
    <mappers>
        <mapper resource="cn/guardwhy/dao/UserMapper.xml"/>
    </mappers>
</configuration>
```

### log4j.properties

```properties
### 设置Logger输出级别和输出目的地 ###
log4j.rootLogger=debug, stdout

### 把日志信息输出到控制台 ###
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.SimpleLayout
```

### 编写用户实体类

```java
package cn.guardwhy.domain;

import java.sql.Date;
/**
 * 用户实体类
 */
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public User() {
    }

    public User(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
```

### 编写用户接口

```java
package com.guardwhy.dao;

import com.itheima.entity.User;

import java.util.List;

/**
 用户dao接口 */
public interface UserMapper {

}
```

### 用户Mapper.xml

在resources资源下创建cn/guardwhy/dao目录

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="">
</mapper>
```

## 通过id查询用户

### 修改UserMapper接口

1. 添加User findUserById(Integer id)方法
2. 注：参数使用引用类型

#### 代码实现

```java
package cn.guardwhy.dao;

import cn.guardwhy.domain.User;

/**
 * 用户dao的接口
 */
public interface UserMapper {
    /**
     *  通过id查询一个用户
     */
    User findUserById(Integer id);
}
```

### 修改UserMapper.xml文件

1. 添加select查询标签，并且设置属性id、parameterType、resultType
2. 编写查询语句，使用占位符#{变量名}

#### 代码实现

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--实体类的映射文件 namespace 指定接口的类全名-->
<mapper namespace="cn.guardwhy.dao.UserMapper">
    <!--
    查询语句
    id: 接口中方法的名字 resultType：返回的实体类的类型,类全名
    -->
    <select id="findUserById" resultType="cn.guardwhy.domain.User" parameterType="java.lang.Integer">
        select * from user where id = #{id}
    </select>
</mapper>
```

### 编写测试类

1. 声明静态成员变量：SqlSessionFactory
2. 成员变量：SqlSession
3. 成员变量：UserMapper
4. 在@BeforeClass中创建工厂对象
5. 在@Before中创建会话对象和userMapper对象
6. 在@Test中编写通过id查询用户的方法

#### 代码实现

```java
package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;

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
        session = factory.openSession(true);	//true设置为自动提交
        // 创建代理对象
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void testFindUserById(){
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }
}
```

## 核心配置文件

sqlMapConfig.xml 是 mybatis 框架的核心配置文件。

| **properties**    | **外部的可替代的属性，可以从 Java 属性配置文件中读取。**     |
| ----------------- | ------------------------------------------------------------ |
| **settings**      | **mybatis 全局的配置参数**                                   |
| **typeAliases**   | **给 Java 类型定义别名**                                     |
| **typeHandlers**  | **类型处理器，将结果集中的值以合适的方式转换成 Java 类型**   |
| **objectFactory** | **可以指定用于创建结果对象的对象工厂**                       |
| **plugins**       | **允许使用插件来拦截 mybatis 中一些方法的调用**              |
| **environments**  | 配置多种环境，可以将 SQL 映射应用于多种数据库之中。<br/><font color=red>**transactionManager**</font> ,  两种事务管理器类型。<br/><font color=red>**dataSource**</font> 指定数据源的类型 |
| **mappers**       | 定义SQL映射语句的配置文件                                    |

### db.properties

编写数据库连接属性资源文件<font color = red>**（db.properties)**，</font>放在resources资源文件下。

```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis
jdbc.username=root
jdbc.password=root
```

#### 加载db.properties属性文件

```xml
<!--在内部配置属性：先读取内部的属性,再读取外部的属性,外部的会覆盖内部的,最后外部的属性起作用-->
<properties resource="db.properties">
    <property name="jdbc.username" value="root"/>
    <property name="jdbc.password" value="root"/>
</properties>
```

### typeAliases

```properties
作用：给用户自定义的实体类定义别名
```

#### 单个别名typeAlias

```xml
typeAlias:
    1.type：指定实体类全名
    2.alias: 指定别名，如果省略这个属性，默认使用类名字做为别名，别名不区分大小写，通常别名使用小写。
<typeAlias type="cn.guardwhy.domain.User"/>
```

#### 包扫描配置别名package

```xml
package指定包名
1. 自动将这个包下所有的实体类定义别名，别名就是类的名字。(在日志输出中会有乱码，不用理会，不影响使用，这是mybatis的bug)
2. 如果有多个子包，只需要指定父包即可。
3. 可以使用多个package标签，指定不同的包名
<package name="cn.guardwhy.domain"/>
```

### mappers（映射器）

#### 加载单个映射文件mapper

注：如果是多级目录，是/而不是点号

```xml
<!--
指定外面的实体类映射文件
resource: 加载类路径下映射文件，不是点号，是/
url: 可以绝对路径的方式访问映射文件.
class: 导入接口类名，用于注解配置的方式 "cn.guardwhy.dao.UserMapper"    
-->
<mapper resource="cn/guardwhy/dao/UserMapper.xml"/>
```

#### 包扫描加载映射文件package

包扫描方式加载mapper映射文件,说明：

1. 要求mapper映射文件，与mapper接口要放在同一个目录
2. 要求mapper映射文件的名称，与mapper接口的名称要一致

```xml
<!--
package表示扫描这个包下所有的映射文件
1. 接口与映射文件在要同一个目录下
2. 接口的名字与映射文件名字要相同
-->
<package name="cn.guardwhy.dao"/>
```

## 模糊查询用户

### 声明mapper接口方法

```java
 // 2.通过用户名查询用户
List<User> findUsersByName(String username);
```

### 配置mapper映射文件

1. 使用字符串拼接符${value}拼接参数
2. 字符串的参数类型此处只能使用value名字
3. 模糊查询前后使用%，外面使用单引号

```xml
<!--
通过名字模糊查询
${value}: 字符串拼接，使用$. 如果是简单类型：(8种基本类型+String类型)，这里变量名只能是value
-->
<select id="findUsersByName" parameterType="String" resultType="user">
   select * from user where username like '%${value}%'
</select>
```

### sqlMapConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!--在内部配置属性：先读取内部的属性,再读取外部的属性,外部的会覆盖内部的,最后外部的属性起作用-->
    <properties resource="db.properties">
        <property name="jdbc.username" value="root"/>
        <property name="jdbc.password" value="root"/>
    </properties>

    <!--定义实体类别名-->
    <typeAliases>
        <!-- package扫描 -->
        <package name="cn.guardwhy.domain"/>
    </typeAliases>
    
    <environments default="default">
        <!-- 其中的一个运行环境，通过id来进行标识-->
        <environment id="default">
            <!--
            事务管理器type的取值：
            1. JDBC：由JDBC进行事务的管理
            2. MANAGED：事务由容器来管理，后期学习Spring框架的时候，所有的事务由容器管理
            -->
            <transactionManager type="JDBC"/>
            <!--
            数据源：
            1. POOLED：使用mybatis创建的连接池
            2. UNPOOLED：不使用连接池，每次自己创建连接
            3. JNDI：由服务器提供连接池的资源，我们通过JNDI指定的名字去访问服务器中资源。
            -->
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>

    <!--映射器-->
    <mappers>
        <!-- package表示扫描这个包下所有的映射文件 -->
        <package name="cn.guardwhy.dao"/>
    </mappers>
</configuration>
```

### 测试代码

```java
package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
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

    // 用完后关闭会话
    @After
    public void end(){
        session.close();
    }
}
```

## 新增用户

### 声明mapper接口方法

```java
 // 3.新增用户
int addUser(User user);
```

### 配置mapper映射文件

1. 新增用户使用insert标签
2. 放置新增sql语句，参数类型使用User
3. 占位符使用user对象的各个#{属性名}

```xml
<!--
 添加用户
 因为增删改没有查询的结果集，所以不用配置resultType。有返回值，返回影响的行数。
-->
<insert id="addUser" parameterType="user">
    insert into user values (null, #{username},#{birthday},#{sex},#{address})
</insert>
```

### 测试代码

插入新的记录：

```java
/**
 添加1个用户
 在mybatis中增删改，默认是手动提交事务
 1. 设置成自动提交 factory.openSession(true);
 2. 自己手动提交 session.commit();
*/
@Test
public void testAddUser(){
    User user = new User(null, "老江", Date.valueOf("1975-03-10"),"男","江州");
    int row = userMapper.addUser(user);
    System.out.println("添加了" + row + "行");
}

// 用完后关闭会话
@After
public void end(){
    session.commit();	// 自己手动提交
    session.close();
}
```

### 提交事务

**事务的处理：**如果Java程序代码执行成功，但是数据库中并没有新增记录。原因是没有提交事务，在对数据库的更新操作中（增、删、改）要求提交事务。

#### 方式一:自动提交事务

```java
factory.openSession(true)
```

#### 方式二:手动提交事务

```java
session.commit()
```

## 查询新增记录的主键值

### 方式一：子元素\<selectKey>

| 属性        | 说明                                                         |
| ----------- | ------------------------------------------------------------ |
| keyColumn   | 主键在表中对应的列名                                         |
| keyProperty | 主键在实体类中对应的属性名                                   |
| resultType  | 主键的数据类型                                               |
| order       | BEFORE: 在添加语句前执行查询主键的语句<br />AFTER: 在添加语句后执行查询主键的语句 |

### 映射文件

mysql中的函数：last_insert_id() 得到最后添加的主键

```xml
<!--
 添加用户
 因为增删改没有查询的结果集，所以不用配置resultType。有返回值，返回影响的行数。
-->
<insert id="addUser" parameterType="user">
    insert into user values (null, #{username},#{birthday},#{sex},#{address})
    <!--
        keyColumn:主键在表中对应的列名
        keyProperty:主键在实体类中对应的属性名
        resultType:主键的数据类型
          order:
            BEFORE: 在添加语句前执行查询主键的语句,AFTER: 在添加语句后执行查询主键的语句.
     -->
    <selectKey keyColumn="id" keyProperty="id" resultType="int" order="AFTER">
        select last_insert_id()
    </selectKey>
</insert>
```

### 方式二：在insert标签中增加属性

| 属性             | 说明                    |
| ---------------- | ----------------------- |
| useGeneratedKeys | true 使得自动生成的主键 |
| keyColumn        | 表中主键的列名          |
| keyProperty      | 实体类中主键的属性名    |

### 配置mapper映射文件

```xml
<insert id="addUser" parameterType="user" useGeneratedKeys="true" keyColumn="id" keyProperty="id">
  insert into user values (null,#{username},#{birthday},#{sex},#{address})
</insert>
```

- 说明：直接在insert标签中增加属性的方式，只适合于支持自动增长主键类型的数据库，比如MySQL或SQL Server。

### 测试代码

```java
/**
通过getId()得到新增的主键值
*/
@Test
public void testAddUser(){
    // 得到主键的值
    Integer id = user.getId();
    System.out.println("生成主键的值:" + id);
}
```

## 修改和删除用户

### 声明mapper接口方法

```java
// 4.根据用户Id修改用户
int updateUser(User user);
```

### 配置mapper映射文件

1. 根据用户id修改用户其它属性
2. 使用update标签：放置修改sql语句
3. 占位符使用：#{属性名}

```xml
<!--修改用户-->
<update id="updateUser" parameterType="user">
    update user set username=#{username}, birthday=#{birthday}, sex=#{sex}, address=#{address} where id = #{id}
</update>
```

### 测试代码

1. 修改8号用户的名字，生日，性别，地址
2. 更新用户对象

```java
@Test
// 更新8号用户
public void testUpdateUser(){
    User user = new User(8, "田跃进", Date.valueOf("1976-05-10"), "男", "秦阳");
    int row = userMapper.updateUser(user);
    System.out.println("更新了" + row + "行");
}
```

## 根据用户id删除用户

### 声明mapper接口方法

```java
// 5.根据用户id删除用户
int deleteUser(Integer id);
```

### 配置mapper映射文件

1. 根据用户Id删除用户
2. delete标签：放置删除sql语句

```xml
<!--删除用户-->
<delete id="deleteUser" parameterType="int">
    delete from user where id = #{id}
</delete>
```

### 测试代码

删除12号用户

```java
// 删除用户
@Test
public void testDeleteUser(){
    int row = userMapper.deleteUser(12);
    System.out.println("删除了" + row + "行记录");
}
```

## 映射文件：三种参数输入类型

### 简单类型

Java简单类型(9种：8种基本+String)

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/18-Mybatis.png)

### POJO类型

POJO（Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBean，即我们前面封装数据使用的实体类。

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/19-Mybatis.png)

### POJO包装类型

包装类型：就是在实体类中包含了其它的实体类。

```java
package cn.guardwhy.domain;
/**
 * 包装类
 */
public class QueryVo {
    private User user; // 包含用户对象
    private String start; // 开始日期
    private String end; // 结束日期

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
```

## 实现多条件查询

### 声明mapper接口方法

```java
// 6.使用POJO包装类型,根据用户名称模糊查询用户
List<User> findUsersByCondition(QueryVo queryVo);
```

### 配置mapper映射文件

1. 使用POJO包装类型，根据用户名称模糊查询用户
2. 在核心配置文件中已经定义了类的别名
3. 占位符使用 '%${user.username}%'，user是QueryVo中的属性
4. 占位符使用#{start}和#{end}
5. 分别使用between和小于大于编写SQL语句

```xml
<select id="findUsersByCondition" parameterType="queryVo" resultType="user">
    select * from user where username like '%${user.username}%' and birthday between #{start} and #{end}
</select>
```

### 测试代码

1. 创建封装条件的对象QueryVo
2. 创建user实体类，设置用户名为"精"，设置user为QueryVo的属性
3. 设置开始日期和结束日期，为1980-1-1到1993-1-1之间出生的。
4. 将QueryVo对象做为查询条件

```java
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
```

## 映射文件:resultType输出类型

输出结果resultType的两种类型

```properties
简单类型:8种基本类型+String类型
POJO实体类型
```

### 声明mapper接口方法

```java
 // 7.统计用户表中某种性别的数量
 int getAmountBySex(String sex);
```

### 配置mapper映射文件

统计用户表中的女生的用户数量 

```xml
<!--统计用户表中某种性别的数量-->
<select id="getAmountBySex" resultType="int" parameterType="String" >
    select count(*) from user where sex=#{sex};
</select>
```

### 测试代码

```java
// 统计用户表某种性别的数量
@Test
public void testGetAmountBySex(){
    int amount = userMapper.getAmountBySex("女");
    System.out.println("女生的数量:" + amount);
}
```

## 映射文件:resultMap输出映射

### 修改表结构

```mysql
-- 复制user为user2新表，新复制的表没有主键约束，没有自增
create table user2 select * from user;

-- 添加主键约束
alter table user2 add primary key (id);

-- 增加自增功能
alter table user2 modify id int auto_increment;

-- 从100开始自增
alter table user2 auto_increment = 100;

-- 修改用户表结构，将用户名字段由username改成user_name
alter table user2 change username user_name varchar(20);

select * from user2;
```

### 查询结果

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/20-Mybatis.png)

### 实体类

```java
package cn.guardwhy.domain;

import java.sql.Date;
/**
 * 用户实体类
 */
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public User() {
    }

    public User(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
```

### 声明mapper接口方法

```java
// 8.通过id查询用户
User findUser2ById(Integer id);
```

### 配置mapper映射文件

```xml
<!--通过id查询user2表-->
<select id="findUser2ById" resultType="user" parameterType="int">
    select * from user2 where id = #{id}
</select>
```

### 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/21-Mybatis.png)

出现问题：<font color=red>**属性与列表不匹配**</font>

#### 解决方法

```properties
1. 在SQL语句中定义别名 as username
2. resultMap
```

### 方式一：定义别名

#### UserMapper.xml中的配置

```xml
<!--通过id查询user2表-->
<select id="findUser2ById" resultType="user" parameterType="int">
    select id, user_name as username, birthday,sex, address from user2 where id = #{id}
</select>
```

#### 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/22-Mybatis.png)

### 方式二：使用resultMap实现

resultMap用于配置sql语句中字段（列）的名称，与java对象中属性名称的对应关系。本质上还是要把执行结果映射到java对象上。

1. 定义一个映射关系，指定它的id
2. 在查询的时候，将查询的结果指定为上面定义的映射

#### 配置mapper映射文件

1. 定义映射，指定id和type，type为实体类的别名
2. id标签：映射主键字段，如果列名与属性名相同可以省略
3. result标签：映射普通字段，指定哪个属性对应哪个列，这里只需映射username即可
4. 在查询的结果中使用resultMap，为上面的映射id

```xml
<!-- 1. 定义映射 id: 映射的名字 type:实体类 -->
<resultMap id="userMap" type="user">
    <!--id表示定义主键列 property: 实体类中属性名 column: 表中主键列 -->
    <id property="id" column="id"/>
    <!--result 定义普通列和Java实体类中属性对应关系-->
    <result property="username" column="user_name"/>
</resultMap>
<!-- 2.通过id查询user2表-->
<select id="findUser2ById" resultMap="userMap" parameterType="int">
    select * from user2 where id = #{id}
</select>
```

#### 测试代码

```java
//通过id查询1个用户
@Test
public void testFindUser2ById(){
    User user = userMapper.findUser2ById(1);
    System.out.println(user);
}
```

#### 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/22-Mybatis.png)

#### 映射流程

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/23-Mybatis.png)