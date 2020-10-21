## 什么是框架

程序开发中的框架往往是对常见功能的封装，程序框架理解为基础或者机械标准件(例如螺丝螺母标准的机械部件)。

假如你要造一辆马车，在没有框架的情况下，你需要自己去伐木，去把木头做成木板，木棍，然后组成轮子，门，等部件，然后组装起来。但如果你用了框架，就相当于你有现成的轮子，门等部件，你只需要组装一下就可以了。一个框架是一组可复用的设计构件。

<font color=red>**框架(Framework)**</font>是整个或者部分系统的可重用设计，是JavaEE底层技术的封装。框架是可以被开发者定制的应用骨架。框架是一个半成品，软件是成品

## 项目的三层结构

一个中大型软件开发需要有明确分层.

| **层**                            | **作用**                                         |
| --------------------------------- | ------------------------------------------------ |
| 表示层 View                       | 面向客户，用于处理客户的输入和输出，前端的代码。 |
| 业务层 Service                    | 处理业务逻辑代码，如：登录，转账，挂号           |
| 数据访问层 DAO Data Access Object | 也叫持久层。面向数据库，实现对数据库增删改查操作 |

**图示：**

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/1-mybatis.png)

### 分层方式

| **分层包**          | **功能描述** |
| ------------------- | ------------ |
| cn.guardwhy.view    | 表示层       |
| cn.guardwhy.service | 业务层       |
| cn.guardwhy.dao     | 数据访问层   |

### 分层的优缺点

**优点：**

1. 降低了代码的耦合度，降低类与类之间关系。有利于团队的开发
2. 项目的可扩展性更好
3. 可维护性更好
4. 可重用性更好，同一个方法可以由多个类去调用。

 **缺点：**

1. 执行效率更低
2. 开发工作量更大
3. 会导致级联的修改，如果修改一个功能，导致三层都要进行修改。

## mybatis框架

### 框架介绍

mybatis是Apache软件基金会下的一个开源项目，前身是iBatis框架。2010年这个项目由apache 软件基金会迁移到google code下，改名为mybatis。2013年11月又迁移到了github。

### mybatis的优点

1. 简单易学：mybatis本身就很小且简单。没有任何第三方依赖，最简单安装只要两个jar文件+配置几个SQL映射文件即可。  
2. 使用灵活：Mybatis不会对应用程序或者数据库的现有设计强加任何影响。SQL语句写在XML里，便于统一管理和优化。
3. 解除SQL与程序代码的耦合：通过提供DAO层，将业务逻辑和数据访问逻辑分离，使系统的设计更清晰，更易维护，更易进行单元测试。SQL语句和代码的分离，提高了可维护性。

### mybatis的不足

1. 编写SQL语句时工作量很大，尤其是字段多、关联表多时，更是如此。
2. SQL语句依赖于数据库，导致数据库移植性差，不能更换数据库。
3. 框架还是比较简陋，功能尚有缺失，二级缓存机制不佳

### ORM的概念

1. Object Relational Mapping 对象关系映射，在Java中编程：**<font color=red>使用的是面向对象的开发方式。</font>**在MySQL中写的SQL语句：**<font color=red>使用的是关系型的数据库将表中的数据映射成一个对象，对象关系映射</font>**。

2. mybatis的两种映射方式 

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/2-mybatis.png)

## 官方网站及框架包下载

### 官方网站

网址：http://www.mybatis.org/mybatis-3/

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/3-mybatis.png)

### 框架包下载

连接到github地址：https://github.com/mybatis/mybatis-3/releases

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/4-mybatis.png)

## 环境的搭建

### 准备数据

要查询的表

```mysql
create table user (
  id int primary key auto_increment,
  username varchar(20) not null,
  birthday date,
  sex char(1) default '男',
  address varchar(50)
);

insert into user values (null, '侯大利','1980-10-24','男','江州');
insert into user values (null, '田甜','1992-11-12','女','扬州');
insert into user values (null, '王永强','1983-05-20','男','扬州');
insert into user values (null, '杨红','1995-03-22','女','秦阳');

select * from user;
```

### 项目结构

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/5-mybatis.png )

### 项目步骤

1、创建maven普通项目

2、倒入相关依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cn.guardwhy</groupId>
    <artifactId>Mybatis</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <!--倒入项目所需依赖-->
    <dependencies>
        <!-- mybatis相关依赖-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.0</version>
        </dependency>
         <!-- mysql数据库相关依赖-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.37</version>
        </dependency>
         <!-- 日志相关依赖-->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
         <!-- 测试相关依赖-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.10</version>
        </dependency>
    </dependencies>
    
</project>
```

3、核心配置文件：**sqlMapConfig.xml**

4、日志记录的配置文件：log4j.properties

5、编写用户DAO接口（UserMapper要编写的方法）

6、编写用户DAO接口映射文件（**UserMapper.xml** 编写SQL语句）

7、修改核心配置文件中sqlMapConfig.xml，加载UserMapper.xml 

8、编写测试代码

**mybatis配置文件分两种**

1. 核心配置文件：sqlMapConfig.xml 配置连接数据库参数
2. 接口映射文件：UserMapper.xml编写SQL语句

### log4j.properties

```properties
### 设置Logger输出级别和输出目的地 ###
log4j.rootLogger=debug, stdout

### 把日志信息输出到控制台 ###
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.SimpleLayout
```

### User实体类

```java
package cn.guardwhy.domain;

import java.sql.Date;

/**
 * 实体类
 */
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    /**
     * 无参构造器
     */
    public User() {
    }

    /**
     * 带参构造器
     */
    public User(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    /**
     * set.get方法
     * @return
     */
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

### UserMapper接口的创建

这个接口其实就是数据访问层：DAO层

```java
package cn.guardwhy.dao;

import cn.guardwhy.enty.User;

import java.util.List;

/**
 * 数据访问层方法
 */
public interface UserMapper {
    // 查找所有用户
    List<User> findAllUsers();
}
```

### 实体映射文件：UserMapper.xml

在resources中创建**<font color=red>cn/guardwhy/dao文件夹</font>**，在目录中创建UserMapper.xml映射文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--
实体类的映射文件
namespace 指定接口的类全名
-->
<mapper namespace="cn.guardwhy.dao.UserMapper">
    <!--
    查询语句
    id: 接口中方法的名字
    resultType：返回的实体类的类型,类全名
    -->
    <select id="findAllUsers" resultType="cn.guardwhy.domain.User">
        select * from user
    </select>
</mapper>
```

### 核心配置文件：sqlMapConfig.xml

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

## 测试类

### 三大对象作用和生命周期

在mybatis中一个会话相当于一次访问数据库的过程，一个会话对象类似于一个Connection连接对象。

1. SqlSessionFactoryBuilder：这是一个临时对象，用完就不需要了。通过这个工厂建造类来创建一个会话工厂。
2. SqlSessionFactory：从一个工厂类中得到一个会话对象，一个项目中只需要创建一个会话工厂对象即可。通过会话工厂对象来创建会话对象。
3. SqlSession： 每次访问数据库都需要创建一个会话对象，这个会话对象不能共享。访问完成以后会话需要关闭。                   

#### 步骤

1. 通过框架提供的Resources类，加载sqlMapConfig.xml，得到文件输入流InputStream对象 

2. 实例化会话工厂创建类SqlSessionFactoryBuilder

3. 通过上面的SqlSessionFactoryBuilder对象，读取核心配置文件的输入流，得到会话工厂SqlSessionFactory类

4. 使用SqlSessionFactory对象，创建SqlSession对象
   1. 它相当于JDBC中的Connection对象，提供了操作数据库的CRUD方法
   2. 它提供了一个getMapper()方法，获取接口的实现对象。

5. 获取接口的对象UserMapper，得到接口的代理对象

6. 执行数据库的查询操作，输出用户信息

7. 关闭会话，释放资源。

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/6-Mybatis.png)

### 测试代码

```java
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
```

