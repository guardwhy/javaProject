## 1-框架概念

程序开发中的框架往往是对常见功能的封装，程序框架理解为基础或者机械标准件(例如螺丝螺母标准的机械部件)。

假如你要造一辆马车，在没有框架的情况下，你需要自己去伐木，去把木头做成木板，木棍，然后组成轮子，门，等部件，然后组装起来。但如果你用了框架，就相当于你有现成的轮子，门等部件，你只需要组装一下就可以了。一个框架是一组可复用的设计构件。

<font color=red>**框架(Framework)**</font>是整个或者部分系统的可重用设计，是JavaEE底层技术的封装。框架是可以被开发者定制的应用骨架。框架是一个半成品，软件是成品

## 2-项目的三层结构

一个中大型软件开发需要有明确分层.

| **层**                            | **作用**                                         |
| --------------------------------- | ------------------------------------------------ |
| 表示层 View                       | 面向客户，用于处理客户的输入和输出，前端的代码。 |
| 业务层 Service                    | 处理业务逻辑代码，如：登录，转账，挂号           |
| 数据访问层 DAO Data Access Object | 也叫持久层。面向数据库，实现对数据库增删改查操作 |

**图示：**

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/1-mybatis.png)

### 2.1分层方式

| **分层包**          | **功能描述** |
| ------------------- | ------------ |
| cn.guardwhy.view    | 表示层       |
| cn.guardwhy.service | 业务层       |
| cn.guardwhy.dao     | 数据访问层   |

### 2.2 分层的优缺点

**优点：**

1. 降低了代码的耦合度，降低类与类之间关系。有利于团队的开发
2. 项目的可扩展性更好
3. 可维护性更好
4. 可重用性更好，同一个方法可以由多个类去调用。

 **缺点：**

1. 执行效率更低
2. 开发工作量更大
3. 会导致级联的修改，如果修改一个功能，导致三层都要进行修改。

## 3-mybatis框架

### 3.1 框架介绍

mybatis是Apache软件基金会下的一个开源项目，前身是iBatis框架。2010年这个项目由apache 软件基金会迁移到google code下，改名为mybatis。2013年11月又迁移到了github。

### 3.2 mybatis的优点

1. 简单易学：mybatis本身就很小且简单。没有任何第三方依赖，最简单安装只要两个jar文件+配置几个SQL映射文件即可。  
2. 使用灵活：Mybatis不会对应用程序或者数据库的现有设计强加任何影响。SQL语句写在XML里，便于统一管理和优化。
3. 解除SQL与程序代码的耦合：通过提供DAO层，将业务逻辑和数据访问逻辑分离，使系统的设计更清晰，更易维护，更易进行单元测试。SQL语句和代码的分离，提高了可维护性。

### 3.3 mybatis的不足

1. 编写SQL语句时工作量很大，尤其是字段多、关联表多时，更是如此。
2. SQL语句依赖于数据库，导致数据库移植性差，不能更换数据库。
3. 框架还是比较简陋，功能尚有缺失，二级缓存机制不佳

### 3.4 ORM的概念

1. Object Relational Mapping 对象关系映射，在Java中编程：**<font color=red>使用的是面向对象的开发方式。</font>**在MySQL中写的SQL语句：**<font color=red>使用的是关系型的数据库将表中的数据映射成一个对象，对象关系映射</font>**。

2. mybatis的两种映射方式 

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/2-mybatis.png)

## 4-官方网站及框架包下载

### 4.1官方网站

网址：http://www.mybatis.org/mybatis-3/

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/3-mybatis.png)

### 4.2 框架包下载

连接到github地址：https://github.com/mybatis/mybatis-3/releases

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/4-mybatis.png)

## 5- 环境的搭建

### 5.1 数据表结构

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

### 5.2 项目结构

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/5-mybatis.png )

### 5.3 项目步骤

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

### 5.4 log4j.properties

```properties
### 设置Logger输出级别和输出目的地 ###
log4j.rootLogger=debug, stdout

### 把日志信息输出到控制台 ###
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.SimpleLayout
```

### 5.5 User实体类

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

### 5.6 UserMapper接口

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

### 5.7 UserMapper.xml

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

### 5.8 sqlMapConfig.xml

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

## 6- 测试类

### 6.1 三大对象作用和生命周期

在mybatis中一个会话相当于一次访问数据库的过程，一个会话对象类似于一个Connection连接对象。

1. SqlSessionFactoryBuilder：这是一个临时对象，用完就不需要了。通过这个工厂建造类来创建一个会话工厂。
2. SqlSessionFactory：从一个工厂类中得到一个会话对象，一个项目中只需要创建一个会话工厂对象即可。通过会话工厂对象来创建会话对象。
3. SqlSession： 每次访问数据库都需要创建一个会话对象，这个会话对象不能共享。访问完成以后会话需要关闭。                   

### 6.2 步骤

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

### 6.3 测试代码

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

## 7- 自定义mybatis框架(Mapper封装数据类)

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/16-Mybatis.png)

## 8- 环境搭建

### 8.1 项目目录

```css
sqlMapConfig.xml核心配置文件，去掉DTD约束。因为dom4j会上网去找dtd文件.
UserMapper.xml映射配置文件，去掉DTD约束。
UserMapper接口
User实体类
```

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/7-Mybatis.png"  />

### 8.2 导入相关jar包

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/9-jarTest.png)

### 8.3 UserMapper.xml

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/10-Mybatis.png)

### 8.4 生成步骤

```css
创建包cn.guardwhy.framework
创建实体类：Mapper包含4个属性：namespace,id,resultType,sql
重写toString()方法，方便后期测试看到封装的结果
生成get和set方法
一个Mapper对象代表一条要操作的查询语句对象
```

### 8.5 代码实现

```java
package cn.guardwhy.framework;
/**
 * 封装UserMapper.xml属性
 */
public class Mapper {
    private String namespace; // 封装接口名
    private String id; // 方法名
    private String resultType; // 返回实体类类型
    private String sql; // 要执行的SQL语句

    /**
     * get.set方法
     * @return
     */
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "namespace='" + namespace + '\'' +
                ", id='" + id + '\'' +
                ", resultType='" + resultType + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }
}
```

## 9- 解析核心配置文件

### 9.1 如何得到XML文档对象

解析XML文件，得到Document对象

```properties
1. 得到输入流InputStream
2. new SAXReader().read(输入流) 返回Document对象
```

#### 9.1.1 Document常用方法

| 方法名                                | 说明                                             |
| ------------------------------------- | ------------------------------------------------ |
| Element getRootElement()              | 得到XML中根元素(标签)                            |
| List\<Node> selectNodes(String xpath) | 通过xpath查询多个节点Node, Node是Element的父接口 |
| Node selectSingleNode(String xpath)   | 通过xpath得到一个节点                            |

#### 9.1.2 Element常用方法

| **方法名**                        | **功能说明**                     |
| --------------------------------- | -------------------------------- |
| **Element element(String  name)** | 通过元素的名字得到它的一个子元素 |

#### 9.1.3  得到与属性相关方法

| 方法名                             | 功能说明                         |
| ---------------------------------- | -------------------------------- |
| String attributeValue(String name) | 通过标签的属性名字，得到属性的值 |

#### 9.1.4 得到文本的方法

| **Element**元素中的方法 | **说明**                               |
| ----------------------- | -------------------------------------- |
| String getTextTrim()    | 得到标签中文本内容，并且去掉前后的空格 |

### 9.2 生成步骤

#### 9.2.1 Configuration基本属性

```properties
1. 创建driver,url, username,password四个属性
2. 实例化1个空的Map集合：封装其它映射文件的XML信息
3. 声明数据源对象DataSource
4. 生成get和set方法，生成toString()方法
```

#### 9.2.2 Configuration解析核心配置文件

1、创建loadSqlMapConfig()方法，它的作用：

```properties
解析sqlMapConfig.xml配置文件，给Configuration中的属性赋值。
解析UserMapper.xml配置文件，给Mapper中的属性赋值                           
```

2、在构造方法中调用方法: loadSqlMapConfig()

### 9.3 分析配置文件

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/11-Mybatis.png)

#### 9.3.1 代码实现

```java
package cn.guardwhy.framework;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.sql.DataSource;
import javax.xml.parsers.SAXParser;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  解析XML文件：sqlMapConfig.xml, UserMapper.xml
 */
public class Configuration {
    // 1.创建连接池的属性
    private String driver;
    private String url;
    private String username;
    private String password;
    // 2.定义连接池
    private DataSource dataSource;

    // 3.实例化1个空的Map集合:封装其它映射文件的XML信息
    private Map<String, Mapper> mappers = new HashMap<>();

    // 4.在构造方法中调用方法: loadSqlMapConfig()
    public Configuration() {
        try {
            loadSqlMapConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 5.解析配置文件方法
    private void loadSqlMapConfig() throws DocumentException {
        // 5.1. 从类路径加载/sqlMapConfig.xml配置文件，创建输入流
        InputStream inputStream = Configuration.class.getResourceAsStream("/sqlMapConfig.xml");
        // 5.2. 使用dom4j得到文档对象
        Document document = new SAXReader().read(inputStream);
        // 5.3. 使用XPath读取所有property元素
        List<Node> nodes = document.selectNodes("//property");
        // 5.4. 遍历每个property元素，读取它的name和value属性值
        for(Node node : nodes){
            Element propertyElement = (Element) node;
            // 得到name属性
            String name = propertyElement.attributeValue("name");
            // 得到value属性
            String value = propertyElement.attributeValue("value");

            // 6.判断name的字符串，如果与类中的属性名相同，则赋值到相应属性中
            switch (name){
                case "driver":
                    this.driver = value;
                    break;
                case "url":
                    this.url = value;
                    break;
                case "username":
                    this.username = value;
                    break;
                case "password":
                    this.password = value;
                    break;
            }
        }

    }

    /***
     * set.get方法
     * @return
     */
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers = mappers;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dataSource=" + dataSource +
                ", mappers=" + mappers +
                '}';
    }
}
```

#### 9.3.2 测试代码

```java
package cn.guardwhy.test;

import cn.guardwhy.framework.Configuration;

public class TestFramework {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        System.out.println(configuration);
    }
}
```

## 10- 解析实体类映射文件

### 10.1 分析配置文件

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/12-Mybatis.png)

### 10.2 生成步骤

解析UserMapper.xml并且封装到Mapper类中

1. 创建新的方法loadMapper(Document document)，将当前的文档对象传递给方法
2. 读取\<mapper>中的resource属性值
3. 通过resource读取它对应的XML文件
4. 得到namespace,id,resultType,sql的值，封装成Mapper对象
5. 在loadSqlMapConfig()中调用此方法

### 10.3 代码实现

```java
// 解析配置文件方法
private void loadSqlMapConfig() throws DocumentException {
    // 解析UserMapper.xml文件
    loadMapper(document);
}

/**
     * 解析xml实体类映射文件
     * @param document
     */
private void loadMapper(Document document) throws DocumentException{
    // 1.读取mapper中的resource属性值
    // 1.1 读取mapper元素
    List<Node> nodes = document.selectNodes("//mapper");
    // 1.2 遍历每个mapper元素
    for (Node node : nodes){
        Element mapperElement = (Element) node;
        // 1.3 读取mapper的resource属性值
        String resource = mapperElement.attributeValue("resource");
        // 2.解析这个XML文件,得到namespace,id,resultType,sql的值

        // 2.1 使用类对象,读取输入流下面的resource.
        InputStream inputStream = Configuration.class.getResourceAsStream("/" + resource);
        // 2.2 创建文档对象
        Document doc = new SAXReader().read(inputStream);
        // 2.3 得到根元素
        Element rootElement = doc.getRootElement();
        // 2.4 得到namespace属性
        String namespace = rootElement.attributeValue("namespace");
        // 2.5 读取根元素下的一个select标签
        Element selectElement = rootElement.element("select");
        // 2.6 得到id属性
        String id = selectElement.attributeValue("id");
        // 2.7 resultType属性
        String resultType = selectElement.attributeValue("resultType");
        // 2.8 SQL属性
        String sql = selectElement.getTextTrim();

        // 3.封装成Mapper对象
        // 3.1 创建一个自定义的Mapper对象,封装上面的三个属性
        Mapper mapper = new Mapper();
        mapper.setId(id);
        mapper.setResultType(resultType);
        mapper.setSql(sql);
        // 3.2 再封装namespace属性
        mapper.setNamespace(namespace);
        // 3.3 将封装好的mapper对象添加到this的mappers属性中,其中键是namespace+"."+id,值是自定义的mapper对象。
        String key = namespace + "." + id;
        this.mappers.put(key, mapper);
    }

}
```

### 10.4 测试代码

```java
package cn.guardwhy.test;

import cn.guardwhy.framework.Configuration;

public class TestFramework {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        System.out.println(configuration);
    }
}
```

## 11- 创建数据源

### 11.1 生成步骤

1. 创建方法：<font color=red>**void createDataSource()**</font>创建数据源，给dataSource属性赋值。
2. 在构造方法中调用上面的方法。
3. 执行测试代码，查看运行结果。

**createDataSource()方法**

```css
创建c3p0的数据源，数据源类：ComboPooledDataSource。
设置数据库有关的属性：driver, url,username,password。
将this的dataSource设置为上面创建好的数据源对象。
```

### 11.2 代码实现

```java
/**
* 4.在构造方法中调用方法: 
*  loadSqlMapConfig()
*  调用createDataSource()方法
*/
public Configuration() {
    try {
        loadSqlMapConfig();
        createDataSource();  //创建数据源
    } catch (Exception e) {
        e.printStackTrace();
    }
}

/**
  创建数据源
*/
private void createDataSource() throws PropertyVetoException {
    //使用c3p0连接池
    ComboPooledDataSource ds = new ComboPooledDataSource();
    //在代码中设置连接池的属性
    ds.setUser(this.username);
    ds.setPassword(this.password);
    ds.setJdbcUrl(this.url);
    ds.setDriverClass(this.driver);
    //创建好的数据源赋值给成员变量
    this.dataSource = ds;
}
```

## 12- 核心组件SqlSession

### 12.1 生成步骤

1. 编写SqlSession类，提供一个getMapper()方法，获取接口的实现对象（代理对象）
2. 测试：调用接口中的方法
3. 其中查询数据库的方法，先不从数据库查，而是将模拟的数据写在代码中。

### 12.2 JDK动态代理

```properties
代理对象由程序在执行的过程中动态生成，写的代码会比较少。
```

### 12.3 Proxy 类中的方法

#### 12.3.1 newProxyInstance()方法

```java
参数列表: static Object newProxyInstance(ClassLoader loader, Class[] interfaces, InvocationHandler h)
作用: 动态生成代理对象。
```

| loader     | 与真实对象相同的类加载器                                     |
| ---------- | ------------------------------------------------------------ |
| interfaces | 代理类所有实现的接口                                         |
| h          | 调用代理对象的接口，使用时传入一个实现类。<br/>需要重写接口中的方法，实现真实对象中每个方法的调用。 |
| 返回       | 生成代理对象                                                 |

**Proxy.newProxyInstance()方法**：创建UserMapper接口的动态代理对象。

#### 12.3.2 InvocationHandler 接口

```java
Object invoke(Object proxy, Method method, Object[] args)
作用：接口中这个方法会调用多次，真实对象中的每个被代理的方法都会调用一次
```

| proxy  | 动态生成的代理对象，不要在方法中直接调用，不然会出现递归死循环的调用。 |
| ------ | ------------------------------------------------------------ |
| method | 真实对象的方法                                               |
| args   | 代理对象调用方法时传递的参数                                 |
| 返回   | 方法的返回值                                                 |

**InvocationHandler匿名类**：

**功能：**

```css
通过键得到Mapper对象
从Mapper对象中得到SQL语句执行，并且封装成对象返回
```

**步骤：**

```css
实例化Configuration对象
通过类全名+"."+方法名得到键
通过键得到值Mapper对象
得到要执行的sql语句和返回的实体类型
通过数据源得到连接对象
执行数据库操作，通过反射封装结果集并且返回
```

#### 12.3.3 invoke() 方法

| method.invoke(Object obj, Object[] args) | 通过反射调用真实对象中的每个方法 |
| ---------------------------------------- | -------------------------------- |
| Object obj                               | 真实对象                         |
| Object[] args                            | 调用真实的方法时传递的参数       |

#### 12.3.4 方法签名

```java
public <T> T getMapper(Class<T> type) 
```

## 13- SqlSession类

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/13-Mybatis.png)

### 13.1 得到SQL语句和返回类型

1、得到Configuration中Map集合

```properties
1. 实例化Configuration对象
2. 通过Configuration得到Mapper对象的集合
```

2、得到Map中的键：类全名.方法名

```properties
1. 通过方法对象->得到声明的接口->得到名称：即类全名 com.itheima.dao.UserMapper
2. 获取当前执行的方法名称：findAllUsers
3. 通过类全名+方法名得到键
```

3、得到Mapper中相应的属性

```properties
1. 通过类全名+"."+方法名，从mappers中得到映射的mapper对象
2. 从mapper中获取查询的sql语句
3. 从mapper中获取返回值类型resultType
4. 通过反射将上面的resultType字符串转成类对象，供后面的方法使用
```

### 13.2  对象访问数据库

1. 通过Configuration得到数据源，通过数据源得到连接对象
2. 调用List queryForList(Connection connection, String sql, Class clazz)方法

```properties
1. 使用JDBC从数据库中查询数据
2. 使用反射来实例化clazz对象，并且封装所有的属性，添加到集合中。
```

图示:

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/14-Mybatis.png)

### 13.3 JDBC访问数据库

```properties
1. 创建集合List封装结果集，未使用泛型
2. 通过Connection连接对象创建预编译的语句对象
3. 执行查询，得到结果集ResultSet
```

**封装数据成List 对象**

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/15-Mybatis.png)

```properties
1. 循环读取每一行结果集
2. 通过反射实例化每个对象
3. 通过类对象得到所有声明的属性，包含私有的。
4. 遍历得到每个属性
5. 设置每个属性为暴力反射
6. 给每个属性赋值，参数：对象，值。从结果集中取出同名的属性值
7. 将每个对象添加到集合中
```

### 13.4 会话类

```java
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
```

### 13.5 测试类

```java
package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.User;
import cn.guardwhy.framework.Configuration;
import cn.guardwhy.framework.SqlSession;

import java.util.List;

public class TestFramework {
    public static void main(String[] args) {
        // 1.使用SqlSession类
        SqlSession session = new SqlSession();
        // 2.调用getMapper(UserMapper.class),返回的就是代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        System.out.println(userMapper.getClass());
        // 3.调用代理对象的方法,得到所有的用户
        List<User> users = userMapper.findAllUsers();
        // 4.输出user
        users.forEach(System.out::println);
    }
}
```

## 14- 搭建项目环境(Mybatis CRUD)

### 14.1 表结构和数据

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

### 14.2 项目目录

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/17-Mybatis.png)

### 14.3 添加依赖

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

### 14.4 sqlMapConfig.xml

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

### 14.5 log4j.properties

```properties
### 设置Logger输出级别和输出目的地 ###
log4j.rootLogger=debug, stdout

### 把日志信息输出到控制台 ###
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.SimpleLayout
```

### 14.6 用户实体类

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

### 14.7 用户接口

```java
package com.guardwhy.dao;

import com.itheima.entity.User;

import java.util.List;

/**
 用户dao接口 */
public interface UserMapper {

}
```

### 14.8 用户Mapper.xml

<font color="red">**在resources资源下创建cn/guardwhy/dao目录**</font>

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="">
</mapper>
```

## 15- 通过id查询用户

### 15.1 UserMapper接口

1. 添加User findUserById(Integer id)方法
2. 参数使用引用类型

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

### 15.2 修改UserMapper.xml文件

1. 添加select查询标签，并且设置属性id、parameterType、resultType
2. 编写查询语句，使用占位符#{变量名}

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

### 15.3 测试类

1. 声明静态成员变量：SqlSessionFactory
2. 成员变量：SqlSession
3. 成员变量：UserMapper
4. 在@BeforeClass中创建工厂对象
5. 在@Before中创建会话对象和userMapper对象
6. 在@Test中编写通过id查询用户的方法

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

### 15.4 核心配置文件

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

#### 15.4.1 db.properties

编写数据库连接属性资源文件<font color = red>**（db.properties)**，</font>放在resources资源文件下。

```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/mybatis
jdbc.username=root
jdbc.password=root
```

#### 15.4.2 加载db.properties属性文件

```xml
<!--在内部配置属性：先读取内部的属性,再读取外部的属性,外部的会覆盖内部的,最后外部的属性起作用-->
<properties resource="db.properties">
    <property name="jdbc.username" value="root"/>
    <property name="jdbc.password" value="root"/>
</properties>
```

#### 15.4.3 typeAliases

```properties
作用：给用户自定义的实体类定义别名
```

##### 15.4.3.1 单个别名typeAlias

```xml
typeAlias:
    1.type：指定实体类全名
    2.alias: 指定别名，如果省略这个属性，默认使用类名字做为别名，别名不区分大小写，通常别名使用小写。
<typeAlias type="cn.guardwhy.domain.User"/>
```

##### 15.4.3.2 包扫描配置别名package

```xml
package指定包名
1. 自动将这个包下所有的实体类定义别名，别名就是类的名字。(在日志输出中会有乱码，不用理会，不影响使用，这是mybatis的bug)
2. 如果有多个子包，只需要指定父包即可。
3. 可以使用多个package标签，指定不同的包名
<package name="cn.guardwhy.domain"/>
```

### 15.4.4 mappers（映射器）

##### 15.4.4.1 加载单个映射文件mapper

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

##### 15.4.4.2 包扫描加载映射文件package

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

## 16- 模糊查询用户

### 16.1 mapper接口方法

```java
 // 2.通过用户名查询用户
List<User> findUsersByName(String username);
```

### 16.2 配置mapper映射文件

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

### 16.3 sqlMapConfig.xml

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

### 16.4 测试代码

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

## 17- 新增用户

### 17.1 mapper接口方法

```java
 // 3.新增用户
int addUser(User user);
```

### 17.2 配置mapper映射文件

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

### 17.3 测试代码

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

### 17.4 提交事务

**事务的处理：**如果Java程序代码执行成功，但是数据库中并没有新增记录。原因是没有提交事务，在对数据库的更新操作中（增、删、改）要求提交事务。

#### 17.4.1 自动提交事务

```java
factory.openSession(true)
```

#### 17.4.2 手动提交事务

```java
session.commit()
```

### 17.5 查询新增记录的主键值

#### 17.5.1 子元素\<selectKey>

| 属性        | 说明                                                         |
| ----------- | ------------------------------------------------------------ |
| keyColumn   | 主键在表中对应的列名                                         |
| keyProperty | 主键在实体类中对应的属性名                                   |
| resultType  | 主键的数据类型                                               |
| order       | BEFORE: 在添加语句前执行查询主键的语句<br />AFTER: 在添加语句后执行查询主键的语句 |

**映射文件**

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

#### 17.5.2 在insert标签中增加属性

| 属性             | 说明                    |
| ---------------- | ----------------------- |
| useGeneratedKeys | true 使得自动生成的主键 |
| keyColumn        | 表中主键的列名          |
| keyProperty      | 实体类中主键的属性名    |

### 17.6 配置mapper映射文件

```xml
<insert id="addUser" parameterType="user" useGeneratedKeys="true" keyColumn="id" keyProperty="id">
  insert into user values (null,#{username},#{birthday},#{sex},#{address})
</insert>
```

- 说明：直接在insert标签中增加属性的方式，只适合于支持自动增长主键类型的数据库，比如MySQL或SQL Server。

### 17.7 测试代码

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

## 18- 修改和删除用户

### 18.1 mapper接口方法

```java
// 4.根据用户Id修改用户
int updateUser(User user);
```

### 18.2 配置mapper映射文件

1. 根据用户id修改用户其它属性
2. 使用update标签：放置修改sql语句
3. 占位符使用：#{属性名}

```xml
<!--修改用户-->
<update id="updateUser" parameterType="user">
    update user set username=#{username}, birthday=#{birthday}, sex=#{sex}, address=#{address} where id = #{id}
</update>
```

### 18.3 测试代码

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

## 19- 根据用户id删除用户

### 19.1 mapper接口方法

```java
// 5.根据用户id删除用户
int deleteUser(Integer id);
```

### 19.2 配置mapper映射文件

1. 根据用户Id删除用户
2. delete标签：放置删除sql语句

```xml
<!--删除用户-->
<delete id="deleteUser" parameterType="int">
    delete from user where id = #{id}
</delete>
```

### 19.3 测试代码

```java
// 删除用户
@Test
public void testDeleteUser(){
    int row = userMapper.deleteUser(12);
    System.out.println("删除了" + row + "行记录");
}
```

## 20- 映射文件：三种参数输入类型

### 20.1 简单类型

Java简单类型(9种：8种基本+String)

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/18-Mybatis.png)

### 20.2 POJO类型

POJO（Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBean，即我们前面封装数据使用的实体类。

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/19-Mybatis.png)

### 20.3 POJO包装类型

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

## 21- 多条件查询

### 21.1 mapper接口方法

```java
// 6.使用POJO包装类型,根据用户名称模糊查询用户
List<User> findUsersByCondition(QueryVo queryVo);
```

### 21.2 配置mapper映射文件

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

### 21.3 测试代码

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

## 22- resultType输出类型

输出结果resultType的两种类型

```properties
简单类型:8种基本类型+String类型
POJO实体类型
```

### 22.1 mapper接口方法

```java
 // 7.统计用户表中某种性别的数量
 int getAmountBySex(String sex);
```

### 22.2 配置mapper映射文件

统计用户表中的女生的用户数量 

```xml
<!--统计用户表中某种性别的数量-->
<select id="getAmountBySex" resultType="int" parameterType="String" >
    select count(*) from user where sex=#{sex};
</select>
```

### 22.3 测试代码

```java
// 统计用户表某种性别的数量
@Test
public void testGetAmountBySex(){
    int amount = userMapper.getAmountBySex("女");
    System.out.println("女生的数量:" + amount);
}
```

## 23- resultMap输出映射

### 23.1 修改表结构

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

### 23.2 查询结果

​	![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/20-Mybatis.png)

### 23.3 用户实体类

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

### 23.4 mapper接口方法

```java
// 8.通过id查询用户
User findUser2ById(Integer id);
```

### 23.5 配置mapper映射文件

```xml
<!--通过id查询user2表-->
<select id="findUser2ById" resultType="user" parameterType="int">
    select * from user2 where id = #{id}
</select>
```

## 24- 查询结果(属性与列表不匹配)

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/21-Mybatis.png)

## 25- 解决方法

### 25.1 UserMapper.xml(定义别名)

```xml
<!--通过id查询user2表-->
<select id="findUser2ById" resultType="user" parameterType="int">
    	<!--在SQL语句中定义别名 as username-->
    select id, user_name as username, birthday,sex, address from user2 where id = #{id}
</select>
```

#### 25.1.1 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/22-Mybatis.png)

### 25.2 使用resultMap实现

resultMap用于配置sql语句中字段（列）的名称，与java对象中属性名称的对应关系。本质上还是要把执行结果映射到java对象上。

```css
定义一个映射关系，指定它的id。
在查询的时候，将查询的结果指定为上面定义的映射。
```

#### 25.2.1 配置mapper映射文件

1. 定义映射，指定id和type，type为实体类的别名。
2. id标签：映射主键字段，如果列名与属性名相同可以省略。
3. result标签：映射普通字段，指定哪个属性对应哪个列，这里只需映射username即可。
4. 在查询的结果中使用resultMap，为上面的映射id。

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

#### 25.2.2 测试代码

```java
//通过id查询1个用户
@Test
public void testFindUser2ById(){
    User user = userMapper.findUser2ById(1);
    System.out.println(user);
}
```

#### 25.2.3 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/22-Mybatis.png)

#### 25.2.4 映射流程

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/23-Mybatis.png)

## 26- 动态SQL

### 26.1 项目目录

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/24-Mybatis.png" style="zoom:80%;" />

### 26.2 会话工厂的工具类

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

## 27- 通过用户和性别查询数据

### 27.1 声明Mapper接口

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

### 27.2 配置mappr映射文件

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

### 27.3 测试代码

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

### 27.4 执行效果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/25-Mybatis.png)

## 28- IF标签

```properties
作用：判断条件是否为真，如果为真则将if中字符串接近到SQL语句中
```

### 28.1 配置mappr映射文件

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

## 29- Where标签

```properties
作用：
1. where标签就相当于SQL语句中where关键字
2. 去掉多余的and,or,where关键字
```

### 29.1 配置mappr映射文件

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

### 29.2 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/25-Mybatis.png)

## 30- Set标签

作用:更新用户信息的时候,有些表单项为空则不用更新。

```properties
1. 用在update这个语句，相当于set关键字
2. 与if标签配合使用，对有值的字段进行更新
3. 可以去掉多余的逗号
```

### 30.1 声明Mapper接口

```java
// 2.更新用户
int updateUser(User user);
```

### 30.2 配置mappr映射文件

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

### 30.3 测试代码

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

### 30.4 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/26-Mybatis.png)

## 31- Foreach标签

### 31.1 参数类型是集合

```properties
作用:拼接SQL语句，中间用到循环,有一段SQL语句出现多次。
```

#### 31.1.1 Mapper接口方法

```java
// 3.批量添加用户
int addUsers(List<User> users);
```

#### 31.1.2 mapper映射文件

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

#### 31.1.3 测试代码

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

#### 31.1.4 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/27-Mybatis.png)

### 31.2 参数类型是数组

#### 31.2.1 mapper接口方法

```java
// 4.批量删除用户
int deleteUsers(int[] ids);
```

#### 31.2.2 配置mapper映射文件

**<font color = red>parameterType 因为内置别名中没有数组类型的参数，所以当参数传递的是list和数组，都写成list</font>**。

```xml
<!--批量删除用户-->
<delete id="deleteUsers" parameterType="list">
    delete from user where id in
    <foreach collection="array" open="(" item="id" separator="," close=")">
        #{id}
    </foreach>
</delete>
```

#### 31.2.3 测试代码

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

#### 31.2.4 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/28-Mybatis.png)

## 32- Sql和include标签

**作用**：

```properties
sql标签：定义一段可以重用的SQL语句
include标签： 引用上面定义的SQL语句
```

### 32.1 mapper接口方法

```java
 // 5.根据条件查询多个用户
List<User> findUserByCondition(Map<String, Object> condition);

// 6.根据条件查询有多少用户
int findUserCount(Map<String, Object> condition);
```

### 32.2 配置mapper映射文件

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

### 32.3 测试代码

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

### 32.4 查询结果

![](https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/29-Mybatis.png)

## 33- 多表查询

### 33.1 项目目录

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/35-Mybatis.png" style="zoom: 80%;" />

## 34- 关联关系分类

三种：1对1，1对多，多对多

### 34.1 一对一关联关系

人和身份证的关系。一个人只能有一张身份证，一张身份证只能属于一个人。双向【一对一】关联关系。

### 34.2 一对多关联关系

举一个例子：用户和订单的关系。

一个用户可以有多个订单，从用户到订单是【一对多】关联关系。

一个订单只能属于一个人，从订单到人是【一对一】的关联关系。

### 34.3 多对多关联关系

举一个例子：业务系统中，用户和角色的关系。

一个用户可以有多种角色：小明有可能是：经理，员工，总经理

一种角色可以有多个用户：经理这个角色，有多个人：kobe , Curry

在实际项目中，多对多关系通过中间表，看成两个一对多关联关系。

## 35- 数据表结构

```mysql
-- drop table if exists user3;

-- 创建用户基本表
create table user(
	id int primary key auto_increment, -- 主键自增长
	username varchar(20) not null,
	birthday date,
	sex char(1) default '男',
	address varchar(50)
);

insert into user3 values (null, '侯大利','1990-10-24','男','江州');
insert into user3 values (null, '王大青','1992-11-12','女','秦阳');
insert into user3 values (null, '朱琳','1983-05-20','男','江州');
insert into user3 values (null, '田大甜','1993-03-22','女','阳州');

-- 查询数据
select * from user;

-- 用户信息表
create table user_info(
	id int primary key, -- 既是主键，又是外键
	height double, -- 身高厘米
	weight double, -- 体重公斤
	married tinyint, -- 是否结婚
	foreign key(id) references user3(id)
);

-- 插入用户数据
insert into user_info values(1,185,90,1),(2,170,60,0);

select * from user_info;
```

## 36- 一对一关联

查询1号用户和他的扩展信息

```mysql
select * from user u inner join user_info i on u.id = i.id where u.id=1
```

### 36.1 用户实体类

- UserInfo类(创建一对一的关系)

```java
package cn.guardwhy.domain;
/**
 * 用户拓展信息类
 */
public class UserInfo {
    private Integer id; // 主键
    private Double height; // 身高
    private Double weight; // 体重
    private Boolean married; // 是否结婚

    private User user; // 用户的基本信息

    /**
     * 无参构造
     */
    public UserInfo() {
    }

    /**
     * 带参构造
     */
    public UserInfo(Integer id, Double height, Double weight, Boolean married, User user) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.married = married;
        this.user = user;
    }

    /**
     * get.set方法
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                ", married=" + married +
                ", user=" + user +
                '}';
    }
}
```

- User类(创建一对一的关系)

```java
package cn.guardwhy.domain;

import java.sql.Date;

/**
 * 用户类
 */
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    private UserInfo userInfo; // 对应的用户扩展信息
    /**
     * 无参构造
     */
    public User() {
    }

    /**
     * 带参构造
     */
    public User(Integer id, String username, Date birthday, String sex, String address, UserInfo userInfo) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.userInfo = userInfo;
    }

    /**
     * get.ste方法
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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
```

### 36.2 Mybatis配置文件

#### 36.2.1 sqlMapConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!--在内部配置属性-->
    <properties resource="db.properties">
        <property name="jdbc.username" value="root"/>
        <property name="jdbc.password" value="root"/>
    </properties>

    <!--定义实体类别名-->
    <typeAliases>
        <package name="cn.guardwhy.domain"/>
    </typeAliases>

    <!-- 一个核心配置文件，可以配置多个运行环境，default默认使用哪个运行环境 -->
    <environments default="default">
        <!-- 其中的一个运行环境，通过id来进行标识-->
        <environment id="default">
            <!--事务管理器 -->
            <transactionManager type="JDBC"/>
            <!--数据源 -->
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
        <package name="cn.guardwhy.dao"/>
    </mappers>
</configuration>
```

#### 36.2.2 用户接口

```java
package cn.guardwhy.dao;

import cn.guardwhy.domain.User;

public interface UserMapper {
    /**
     * 通过uid查找用户和拓展信息
     */
    User findUserAndInfo(int uid);
}
```

#### 36.2.3 用户Mapper.xml

**association标签**：实现一对一关系

| association标签的属性 | 说明                                           |
| --------------------- | ---------------------------------------------- |
| property              | 一对一对应的另一方实体类的属性名，如：userInfo |
| resultMap             | 指定另一方映射配置的id，如：用户扩展信息的映射 |

1. 定义User的映射**<font color = red>userMap</font>**，包含主键和所有的属性，无论属性名与列名是否相同。

2. 定义用户信息的映射**<font color= "#009999">userInfoMap</font>**，包含主键和所有的属性，无论属性名与列名是否相同。

3. **<font color=#333399>定义映射userAndInfoMap，extends继承于userMap，同时必须指定type属性</font>**。

4. 使用association定义一对一关联映射，**<font color = #990099>指定：property、resultMap属性，将resultMap指定为userInfoMap</font>**。

5. 使用表连接查询：通过用户id查询用户和对应的用户扩展信息，查询结果映射为userAndInfoMap。 

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 实体类接口的类全名 -->
<mapper namespace="cn.guardwhy.dao.UserMapper">
    <!--1.创建User的映射-->
    <resultMap id="userMap" type="user">
        <!--映射主键-->
        <id property="id" column="id"/>
        <result property="username" column="username"/>
        <result property="birthday" column="birthday"/>
        <result property="sex" column="sex"/>
        <result property="address" column="address"/>
    </resultMap>

    <!--2.创建UserInfo的映射-->
    <resultMap id="userInfoMap" type="userInfo">
        <!--映射主键-->
        <id property="id" column="id"/>
        <result property="height" column="height"/>
        <result property="weight" column="weight"/>
        <result property="married" column="married"/>
    </resultMap>

    <!--3.创建一对一的关联extends，将上面的映射关系复制过来-->
    <resultMap id="userAndInfoMap" type="user" extends="userMap">
        <!--一对一关联-->
        <association property="userInfo" resultMap="userInfoMap"/>
    </resultMap>

    <!--4.使用上面的一对一的映射-->
    <select id="findUserAndInfo" resultMap="userAndInfoMap" parameterType="int">
        select * from user3 u inner join user_info i on u.id = i.id where u.id = #{id}
    </select>
</mapper>
```

#### 36.2.4 测试代码

查询输出用户和扩展信息

```java
package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.User;
import cn.guardwhy.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    // 3.关闭会话
    @After
    public void end(){
        // 手动提交
        session.commit();
        session.close();
    }
}
```

#### 36.2.5 执行结果

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/36-Mybatis.png" style="zoom:67%;" />

## 37-  一对多关联

### 37.1 订单模型

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/37-Mybatis.png" style="zoom:67%;" />

### 37.2 数据表结构

```mysql
-- 创建订单表
create table order_form(
    oid int primary key auto_increment ,   -- 主键
    user_id int not null,   -- 用户id，外键
    number varchar(20),   -- 订单编号
    create_time datetime,  -- 下单时间
    note varchar(100),   -- 备注
    foreign key(user_id) references user(id)   -- 外键约束，关联主表的主键
);

-- 添加订单数据
insert into order_form values(null, 1,'10001001', now(), '请提前安装'),(null, 1,'10001002', now(), '包邮'),(null, 1,'10001003', now(), '选择红色');
insert into order_form values(null, 2,'10001004', now(), '购买多件'),(null, 2,'10001005', now(), '安全带');
-- 查询订单表
select * from order_form;
```

### 37.3 数据表关系

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/39-Mybatis.png" style="zoom:67%;" />

### 37.4 用户实体类

- OrderForm(创建一对多的关系)

```java
package cn.guardwhy.domain;

import java.sql.Timestamp;

/**
 * 订单实体类
 */
public class OrderForm {
    private Integer oid; // 主键
    private Integer userId; // 外键
    private String number; // 订单号
    private Timestamp createTime; // 下单时间
    private String note; // 备注信息
    private User user; // 用户信息

    // 无参构造
    public OrderForm() {
    }

    // 带参构造
    public OrderForm(Integer oid, Integer userId, String number, Timestamp createTime, String note) {
        this.oid = oid;
        this.userId = userId;
        this.number = number;
        this.createTime = createTime;
        this.note = note;
    }

    /**
     * get.set方法
     */
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "oid=" + oid +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createTime=" + createTime +
                ", note='" + note + '\'' +
                '}';
    }
}
```

- User(创建一对多的关系)

```java
package cn.guardwhy.domain;

import java.sql.Date;
import java.util.List;

/**
 * 用户类
 */
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    private UserInfo userInfo; // 对应的用户扩展信息
    private List<OrderForm> orders; // 对应所有的订单信息
    /**
     * 无参构造
     */
    public User() {

    }

    /**
     * 带参构造
     */
    public User(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    /**
     * get.ste方法
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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<OrderForm> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderForm> orders) {
        this.orders = orders;
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

### 37.5 Mybatis配置文件

#### 37.5.1 用户接口

```java
/**
  * 查询全部用户数据并且查询用户的所有订单数据
*/
User findUserAndOrders(int uid);
```

#### 37.5.2 用户Mapper.xml

**collection标签**：用来配置1对多的关联映射

| collection的属性 | 说明                                |
| ---------------- | ----------------------------------- |
| property         | 多方属性的名字，如：orders          |
| javaType         | 多方的属性类型，可以省略。如：list  |
| ofType           | 集合中每个元素的类型，如：orderForm |
| resultMap        | 多方的映射，如：订单映射 orderMap   |

**步骤**

1. 定义订单的映射orderMap
2. 配置用户到订单的一对多关联关系userOrdersMap，继承于userMap
3. collection：配置一对多关联关系，指定property，ofType，resultMap为orderMap          
4. 查询某个用户，并且查询关联的多个订单信息，结果为userOrdersMap

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 实体类接口的类全名 -->
<mapper namespace="cn.guardwhy.dao.UserMapper">
    <!--创建User的映射-->
    <resultMap id="userMap" type="user">
        <!--映射主键-->
        <id property="id" column="id"/>
        <result property="username" column="username"/>
        <result property="birthday" column="birthday"/>
        <result property="sex" column="sex"/>
        <result property="address" column="address"/>
    </resultMap>

    <!--1.2创建UserInfo的映射-->
    <resultMap id="userInfoMap" type="userInfo">
        <!--映射主键-->
        <id property="id" column="id"/>
        <result property="height" column="height"/>
        <result property="weight" column="weight"/>
        <result property="married" column="married"/>
    </resultMap>

    <!--1.3 创建一对一的关联extends，将上面的映射关系复制过来-->
    <resultMap id="userAndInfoMap" type="user" extends="userMap">
        <!--一对一关联-->
        <association property="userInfo" resultMap="userInfoMap"/>
    </resultMap>

    <!--1.4 使用上面的一对一的映射-->
    <select id="findUserAndInfo" resultMap="userAndInfoMap" parameterType="int">
        select * from user u inner join user_info i on u.id = i.id where u.id = #{id}
    </select>

    <!--创建订单的映射-->
    <resultMap id="orderMap" type="orderForm">
        <id property="oid" column="oid"/>
        <result property="userId" column="user_id"/>
        <result property="number" column="number"/>
        <result property="createTime" column="create_time"/>
        <result property="note" column="note"/>
    </resultMap>

    <!--配置一对多的映射-->
    <resultMap id="userOrdersMap" type="user" extends="userMap">
        <!--
           property: 多方的属性名
           javaType：多方的属性类型
           ofType: 集合中每个元素的类型
           resultMap：多方映射
       -->
        <collection property="orders" javaType="list" ofType="orderForm" resultMap="orderMap"/>
   </resultMap>
    <!--一对多的关联查询-->
   <select id="findUserAndOrders" resultMap="userOrdersMap" parameterType="int">
       select * from user u inner join order_form o on u.id = o.user_id where u.id=#{id}
   </select>
</mapper>
```

### 37.6 测试代码

```java
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
```

### 37.7 执行结果

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/40-Mybatis.png" style="zoom:67%;" />

## 38- 多对多关联

多对多关联关系，可以通过中间表看成两个双向的一对多关联关系。

### 38.1 关联模型

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/42-Mybatis.png" style="zoom: 80%;" />

### 38.2 数据表结构

```mysql
-- 创建角色表
create table role(
	role_id int primary key auto_increment comment '角色id(主键)',
	role_name varchar(32) not null comment '角色名称',
	role_detail varchar(100) default null comment '角色描述'
);

-- 插入角色记录
insert into role(role_name, role_detail) values('局长', '公安局的管理者');
insert into role(role_name, role_detail) values('普通刑警', '刑侦破案');
insert into role(role_name, role_detail) values('法医', '协助刑警破案');
insert into role(role_name, role_detail) values('支队长', '刑警管理者');

select * from role;

-- 创建用户的角色中间表
create table user_role(
	user_id int not null comment '用户id',
	role_id int not null comment '角色id',
	primary key(user_id, role_id), -- 复合主键
	foreign key(user_id) references user(id),
	foreign key(role_id) references role(role_id)
);

insert into user_role(user_id, role_id) values(1,1);
insert into user_role(user_id, role_id) values(2,2);
insert into user_role(user_id, role_id) values(6,2);
insert into user_role(user_id, role_id) values(1,3);
insert into user_role(user_id, role_id) values(2,1);
insert into user_role(user_id, role_id) values(2,4);

-- 查询用户角色中间表
select * from user_role;

-- 查询1号用户有哪些角色
select *from user u inner join user_role ur on u.id = ur.user_id inner join role r on r.role_id = ur.role_id where u.id = 1;
```

### 38.3 角色实体类

#### 38.3.1 Role(角色实体类)

```java
package cn.guardwhy.domain;

import java.util.List;

/**
 角色实体类
 */
public class Role {

    private Integer roleId;
    private String roleName;
    private String roleDetail;

    private List<User> users;  //对应多个用户

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDetail='" + roleDetail + '\'' +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDetail() {
        return roleDetail;
    }

    public void setRoleDetail(String roleDetail) {
        this.roleDetail = roleDetail;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
```

#### 38.3.2 User(创建多对多的关系)

```java
package cn.guardwhy.domain;

import java.sql.Date;
import java.util.List;

/**
 * 用户类
 */
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    private UserInfo userInfo; // 对应的用户扩展信息
    private List<OrderForm> orders; // 对应所有的订单信息
    private List<Role> roles; // 对应多个角色
    /**
     * 无参构造
     */
    public User() {

    }

    /**
     * 带参构造
     */
    public User(Integer id, String username, Date birthday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    /**
     * get.ste方法
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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<OrderForm> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderForm> orders) {
        this.orders = orders;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

### 38.4 Mybatis配置文件

#### 38.4.1用户接口类

```java
/**
 * 通过uid查找用户和他的所有角色
*/
User findRolesByUserId(int uid);
```

#### 38.4.2 用户Mapper.xml

1. 定义User的映射配置userMap(已经配置)
2. 定义角色的映射roleMap，配置主键和所有的属性
3. 定义一个用户对象对应多个角色userRolesMap，继承于userMap
4. 使用collection关联映射，指定property，javaType，ofType，resultMap为roleMap
5. 定义查询findUserAndInfo，映射结果是：userRolesMap

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 实体类接口的类全名 -->
<mapper namespace="cn.guardwhy.dao.UserMapper">
    <!--创建User的映射-->
    <resultMap id="userMap" type="user">
        <!--映射主键-->
        <id property="id" column="id"/>
        <result property="username" column="username"/>
        <result property="birthday" column="birthday"/>
        <result property="sex" column="sex"/>
        <result property="address" column="address"/>
    </resultMap>
    
    <!--3.1 配置角色的映射-->
    <resultMap id="roleMap" type="role">
        <id property="roleId" column="role_id"/>
        <id property="roleName" column="role_name"/>
        <id property="roleDetail" column="role_Detail"/>
    </resultMap>

    <!--3.2 配置多对多的映射-->
    <resultMap id="userRolesMap" type="user" extends="userMap">
        <!--
           property: 多方的属性名
           javaType：多方的属性类型
           ofType: 集合中每个元素的类型
           resultMap：多方映射
       -->
        <collection property="roles" javaType="list" ofType="role" resultMap="roleMap"/>
    </resultMap>

    <!--3.3 查询某个用户对应的角色-->
    <select id="findRolesByUserId" resultMap="userRolesMap" parameterType="int">
        select *from user u inner join user_role ur on u.id = ur.user_id
        inner join role r on r.role_id = ur.role_id where u.id = #{id};
    </select>
</mapper>
```

### 38.5 测试代码

```java
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
```

### 38.6 执行结果

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/43-Mybatis.png" style="zoom:67%;" />

## 39- 延迟加载

延迟加载又称为懒加载，按需加载。每次只查询1张表，当需要另一张关联表中的数据的时候，再发送一条SQL语句去查询另一张表中数据。

一对一关联查询使用标签：**association**

一对多关联查询使用标签：**collection**

### 39.1 项目目录

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/44-Mybatis.png" style="zoom: 80%;" />

### 39.2 数据库查询语句

```mysql
-- 1. 查询1号用户的信息
select * from user where id=1;

-- 2. 查询1号用户的扩展信息
select * from user_info where id=1;
```

### 39.3 用户接口

```java
package cn.guardwhy.dao;

import cn.guardwhy.domain.User;
import cn.guardwhy.domain.UserInfo;

/**
 * 持久化接口:UserMapper
 */
public interface UserMapper {
    /**
     * 通过id查询1个用户
     */
    User findUserById(int id);

    /**
     * 通过id查询1个用户扩展信息
     */
    UserInfo findUserInfoById(int id);
}
```

### 39.4 UserMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 实体类接口的类全名 -->
<mapper namespace="cn.guardwhy.dao.UserMapper">
    <!--通过id查询1个用户-->
    <select id="findUserById" resultType="User">
        select * from user where id = #{id}
    </select>

    <!--通过id查询一个用户的拓展信息-->
    <select id="findUserInfoById" resultType="userInfo">
        select * from user_info where id = #{id}
    </select>
</mapper>
```

### 39.5 测试代码

```java
package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.User;
import cn.guardwhy.domain.UserInfo;
import cn.guardwhy.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUserMapper {
    private static SqlSessionFactory factory;
    private SqlSession session;
    private UserMapper userMapper;

    // 创建会话对象,自动提交事务
    @Before
    public void begin(){
        session = SessionFactoryUtils.getSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void testFindUserAndInfo(){
        User user = userMapper.findUserById(1);
        System.out.println("用户信息:" + user);

        UserInfo info = userMapper.findUserInfoById(1);
        System.out.println("用户拓展信息:" + info);
    }

    // 关闭会话
    @After
    public void end(){
        // 手动提交
        session.commit();
        session.close();
    }
}
```

### 39.6 执行结果

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/45-Mybatis.png" style="zoom: 67%;" />

## 40 一对一的延迟加载

### 40.1 需求案例

```css
通过id查询1号用户User的基本信息，显示用户名和性别
使用延迟加载的方式，关联查询出对应的用户扩展信息UserInfo，身高和体重。       
```

### 40.2 UserMapper.xml

**步骤：**

1. 通过id查询用户扩展信息，查询id为findUserInfoById，指定查询结果为userInfoMap。
2. 配置映射id为userAndInfoMap中配置关联映射association，指定property、column和select属性。
3. 指定select为上面的findUserInfoById查询，column指定用户主表中的主键id。
4. 根据用户id查询用户基本信息，指定查询结果为userAndInfoMap。

| association标签的属性 | 说明                      |
| --------------------- | ------------------------- |
| property              | 另一方的属性名            |
| column                | 主表的主键                |
| select                | 通过主键再去查询的SQL语句 |

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 实体类接口的类全名 -->
<mapper namespace="cn.guardwhy.dao.UserMapper">
    <!--创建User的映射-->
    <resultMap id="userMap" type="user">
        <!--映射主键-->
        <id property="id" column="id"/>
        <result property="username" column="username"/>
        <result property="birthday" column="birthday"/>
        <result property="sex" column="sex"/>
        <result property="address" column="address"/>
    </resultMap>

    <!--创建UserInfo的映射-->
    <resultMap id="userInfoMap" type="userInfo">
        <!--映射主键-->
        <id property="id" column="id"/>
        <result property="height" column="height"/>
        <result property="weight" column="weight"/>
        <result property="married" column="married"/>
    </resultMap>

    <!--创建一对一的关联extends,将上面的映射关系复制过来-->
    <resultMap id="userAndInfoMap" type="user" extends="userMap">
        <!--
        property：另一方的属性名
        column：主表中主键列
        select: 查询另一方的SQL语句
        -->
        <association property="userInfo" column="id" select="findUserInfoById"/>
    </resultMap>

    <!--通过id查询1个用户-->
    <select id="findUserById" resultMap="userAndInfoMap">
        select * from user where id = #{id}
    </select>

    <!--通过id查询一个用户的拓展信息-->
    <select id="findUserInfoById" resultMap="userInfoMap">
        select * from user_info where id = #{id}
    </select>
</mapper>
```

### 40.3 开启延迟加载

sqlMapConfig.xml中开启延迟加载的settings中的lazyLoadingEnabled

```xml
<!--开启延迟加载-->
<settings>
    <setting name="lazyLoadingEnabled" value="true"/>
</settings>
```

### 40.4 测试代码

1. 通过id查询用户对象
2. 输出用户名和性别的属性
3. 查询用户之后，再查询用户扩展信息

```java
@Test
public void testFindUserById(){
    User user = userMapper.findUserById(1);
    System.out.println("用户名:" + user.getUsername() + ", 性别:" + user.getSex());
    // 需要用户的拓展信息
    UserInfo userInfo = user.getUserInfo();
    System.out.println("身高:" + userInfo.getHeight() + ", 体重:" + userInfo.getWeight());
}
```

### 40.5 执行结果

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/46-Mybatis.png" style="zoom:80%;" />

## 41 一对多的延迟加载

### 41.1 需求案例

```css
查询1号用户的订单信息。
查询1号用户数据，并且关联查询出这个用户所有的订单数据，使用延迟加载方式实现。
```

### 41.2 数据表查询

```mysql
-- 查询1号用户的信息
select * from user where id=1;

-- 查询1号用户的订单信息
select * from order_form where user_id=1;
```

### 41.3 编写用户接口

```java
/**
 * 通过id查询1个用户
*/
User findUserById(int id);

/**
* 通过id查询1个用户扩展信息
*/
UserInfo findUserInfoById(int id);

/**
  通过userId查询这个用户所有的订单信息
*/
List<OrderForm> findOrdersByUserId(int userId);
```

### 41.4 UserMapper.xml

1. 保留订单表的映射orderMap
2. 增加根据用户id查询订单数据配置
3. 修改userAndInfoMap映射，添加collection标签，指定select和column属性

```css
select为findOrdersByUserId。
column为user主表中的主键id
```

注意：这里与association关联配置到一起了，也可以分开映射。

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 实体类接口的类全名 -->
<mapper namespace="cn.guardwhy.dao.UserMapper">
    <!--创建User的映射-->
    <resultMap id="userMap" type="user">
        <!--映射主键-->
        <id property="id" column="id"/>
        <result property="username" column="username"/>
        <result property="birthday" column="birthday"/>
        <result property="sex" column="sex"/>
        <result property="address" column="address"/>
    </resultMap>

    <!--创建订单的映射-->
    <resultMap id="orderMap" type="orderForm">
        <id property="id" column="id"/>
        <result property="userId" column="user_id"/>
        <result property="number" column="number"/>
        <result property="createTime" column="crate_time"/>
        <result property="note" column="note"/>
    </resultMap>

    <!--创建UserInfo的映射-->
    <resultMap id="userInfoMap" type="userInfo">
        <!--映射主键-->
        <id property="id" column="id"/>
        <result property="height" column="height"/>
        <result property="weight" column="weight"/>
        <result property="married" column="married"/>
    </resultMap>
    
    <!--查询某个用户的订单信息-->
    <select id="findOrdersByUserId" resultMap="orderMap">
        select * from order_form where user_id= #{id};
    </select>

    <!--创建一对一的关联extends,将上面的映射关系复制过来-->
    <resultMap id="userAndInfoMap" type="user" extends="userMap">
        <!--
        property：另一方的属性名
        column：主表中主键列
        select: 查询另一方的SQL语句
        -->
        <association property="userInfo" column="id" select="findUserInfoById"/>

        <!--创建一对多的关联-->
        <collection property="orders" column="id" select="findOrdersByUserId"/>
    </resultMap>

    <!--通过id查询1个用户-->
    <select id="findUserById" resultMap="userAndInfoMap">
        select * from user where id = #{id}
    </select>

    <!--通过id查询一个用户的拓展信息-->
    <select id="findUserInfoById" resultMap="userInfoMap">
        select * from user_info where id = #{id}
    </select>
</mapper>
```

### 41.5 测试代码

```java
/**
 * 一对多的延迟加载
*/
@Test
public void testFindUserById2(){
    User user = userMapper.findUserById(1);
    System.out.println("用户名:" + user.getUsername() + ", 性别:" + user.getSex());
    // 使用订单信息
    List<OrderForm> orders = user.getOrders();
    orders.forEach(System.out::println);
}
```

### 41.6 执行结果

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/47-Mybatis.png" style="zoom:80%;" />

## 42- 注解开发方式

### 42.1 项目目录

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/48-Mybatis.png" style="zoom:80%;" />

### 42.2 UserMapper接口

#### 42.2.1 查询用户（@Select）

| 注解     | 属性                    | 说明                         |
| -------- | ----------------------- | ---------------------------- |
| @Select  | value：查询SQL语句      | 查询的注解                   |
| @Results | value：是一个Result数组 | 定义映射关系                 |
| @Result  | column                  | 定义表中列                   |
|          | property                | 定义实体类中属性             |
|          | id                      | true 这是主键列，默认是false |

1. 增加通过id查询用户的方法
2. 方法上使用注解@Select("SQL语句")
3. 在SQL语句使用#{id}占位符

```java
/**
  * 通过id查询1个用户
*/
@Select("select * from user where id = #{id}")
User findUserById(int id);
```

#### 42.2.2 使用@Results和@Result属性

```java
/**
 * 通过id查询1个用户
*/
@Select("select * from user where id = #{id}")
@Results({
    @Result(column = "id", property = "id", id = true), // 映射主键
    @Result(column = "user_name", property = "username") // 映射普通列
})
User findUserById(int id);
```

#### 42.2.3修改用户（@Update）

1. 写修改方法
2. 在方法上使用注解@Update("SQL语句")
3. 占位符使用#{属性名}

```java
/**
 *  根据用户id修改用户
*/
@Update("update user set username=#{username}, address=#{address} where id=#{id}")
int updateUser(User user);
```

#### 42.2.4删除用户（@Delete）

1. 编写删除方法
2. 使用注解@Delete("SQL")
3. 使用#{id}，删除指定的用户

如果有外键约束，主表中记录不能删除。

```java
/**
 * 删除记录
*/
@Delete("delete from user where id=#{id}")
int deleteUser(Integer id);
```

#### 42.2.5新增用户（@Insert）

1. 在UserMapper接口中，增加新增用户方法
2. 使用注解@Insert("SQL语句")

```java
/**
 * 插入一条记录
*/
@Insert("insert into user values (null, #{username},#{birthday},#{sex},#{address})")
int addUser(User user);
```

#### 42.2.6 获取新增主键值@SelectKey

得到自增长生成的主键值

| 属性        | 说明                 |
| ----------- | -------------------- |
| statement   | 获取主键的SQL语句    |
| keyProperty | 实体类中主键的属性名 |
| keyColumn   | 表中主键列的名字     |
| resultType  | 主键数据类型         |
| before      | false 之后 true之前  |

```java
/**
 * 插入一条记录
*/
@Insert("insert into user values (null, #{username},#{birthday},#{sex},#{address})")
/**
 statement:获取主键的SQL语句
 keyProperty: 实体类中主键的属性名
 keyColumn:表中主键列的名字
 resultType:主键数据类型
 before: false 之后 true之前
*/
@SelectKey(statement = "select last_insert_id()", keyProperty = "id", keyColumn = "id", resultType = Integer.class, before = false)
int addUser(User user);
```

### 42.3 测试代码

```java
package cn.guardwhy.test;

import cn.guardwhy.dao.UserMapper;
import cn.guardwhy.domain.User;
import cn.guardwhy.utils.SessionFactoryUtils;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class TestUserMapper {
    private static SqlSessionFactory factory;
    private SqlSession session;
    private UserMapper userMapper;

    // 创建会话对象,自动提交事务
    @Before
    public void begin(){
        session = SessionFactoryUtils.getSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    /***
     * 查询操作
     */
    @Test
    public void testFindUserById(){
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }

    /**
     * 更新操作
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setUsername("田甜");
        user.setAddress("广州");
        user.setId(4);
        int row = userMapper.updateUser(user);
        System.out.println("更新了" + row + "行");
    }


    /**
     * 添加操作
     */
    @Test
    public void testAddUser(){
        User user = new User(null, "王永强", Date.valueOf("1990-2-10"), "男", "秦阳");
        int row = userMapper.addUser(user);
        System.out.println("添加了" + row + "条记录");
        System.out.println("生成的主键:" + user.getId());
    }

    // 关闭会话
    @After
    public void end(){
        // 手动提交
        session.commit();
        session.close();
    }
}
```

## 43- 一对一关联查询

| 注解     | 作用                                                         |
| -------- | ------------------------------------------------------------ |
| @Select  | 查询操作                                                     |
| @Results | 配置一对一在关联映射                                         |
| @Result  | column：主表的主键<br />property：另一方属性名<br />one：配置关联关系 |
| @One     | select：查询另一张表的方法<br />fetchType： LAZY 延迟加载  EAGER 及时加载。 |

### 43.1 sqlMapConfig.xml

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
        <package name="cn.guardwhy.domain"/>
    </typeAliases>

    <environments default="default">
        <!-- 环境变量 -->
        <environment id="default">
            <!--事务管理器 -->
            <transactionManager type="JDBC"/>
            <!--数据源 -->
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
        <package name="cn.guardwhy.dao"/>
    </mappers>
</configuration>
```

### 43.2 UserMapper接口

```java
package cn.guardwhy.dao;

import cn.guardwhy.domain.OrderForm;
import cn.guardwhy.domain.User;
import cn.guardwhy.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 持久化接口:UserMapper
 */
public interface UserMapper {
    /**
     * 通过id查找用户
     */
    @Select("select * from user where id = #{id}")
    @Results({
            // column:主表的主键 property:另一方的属性名, one:配置一对一的关联关系
            @Result(column = "id", property = "userInfo",
                    // select:读取另一个对象查询方法 fetchType:LAZY延迟加载,EAGER及时加载。
                    one = @One(select = "findUserInfoById", fetchType = FetchType.LAZY))
    })
    User findUserById(@Param("id") int id);

    /**
     * 通过id查询用户拓展信息
     */
    @Select("select * from user_info where id = #{id}")
    UserInfo findUserInfoById(int id);
}
```

### 43.3 测试代码

```java
/**
一对一关联查询
1. 只查询用户名和性别
2. 同时查询用户扩展信息
*/
@Test
public void testFindUserById(){
    User user = userMapper.findUserById(1);
    System.out.println("用户名:" + user.getUsername());
    UserInfo userInfo = user.getUserInfo();
    System.out.println(userInfo);
}
```

### 43.4 执行结果

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/49-Mybatis.png" style="zoom:67%;" />

## 44- 一对多关联查询

| @Result注解属性 | 说明             |
| --------------- | ---------------- |
| column          | 主表的主键       |
| property        | 另一方的属性名   |
| many            | 一对多的关联映射 |

| @Many注解属性 | 说明               |
| ------------- | ------------------ |
| select        | 查询另一方的方法   |
| fetchType     | 指定是否是延迟加载 |

### 44.1 UserMapper接口

1、通过user_id查询当前用户订单的方法

```css
使用@Select注解。
```

2、修改findUserById()方法，增加1对多延迟加载配置

```css
在findUserById()方法修改注解。
在@Results注解中添加@Result注解。
```

注意：

```css
column: 为user表中的主键id
property: 对应用户表中的订单集合属性orders
```

3、many为 @Many注解

```css
select：为上面的查询方法名
fetchType：为延迟加载
```

**代码实现**

```java
package cn.guardwhy.dao;

import cn.guardwhy.domain.OrderForm;
import cn.guardwhy.domain.User;
import cn.guardwhy.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 持久化接口:UserMapper
 */
public interface UserMapper {
    /**
     * 通过id查找用户
     */
    @Select("select * from user where id = #{id}")
    @Results({
            // column:主表的主键 property:另一方的属性名, one:配置一对一的关联关系
            @Result(column = "id", property = "userInfo",
                    // select:读取另一个对象查询方法 fetchType:LAZY延迟加载,EAGER及时加载。
                    one = @One(select = "findUserInfoById", fetchType = FetchType.LAZY)),
            // 配置1对多的关系,column:主表的主键, property：方法的属性名, many：配置一对多的关联关系
            @Result(column = "id", property = "orders", many = @Many(select = "findOrderByUserId", fetchType = FetchType.LAZY))
    })
    
    User findUserById(@Param("id") int id);
    
    /**
     * 通过userId查询这个用户所有的订单信息
     */
    @Select("select * from order_form where user_id = #{userId}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "create_time", property = "createTime")
    })
    List<OrderForm> findOrderByUserId(int userId);
}

```

### 44.2 测试代码

```java
/**
一对多关联查询
1. 只查用户信息
2. 查询订单信息
*/
@Test
public void testFindUserById(){
    User user = userMapper.findUserById(1);
    System.out.println("用户名:" + user.getUsername());
    /*UserInfo userInfo = user.getUserInfo();
        System.out.println(userInfo);*/

    // 1对多
    List<OrderForm> orders = user.getOrders();
    orders.forEach(System.out::println);
}
```

### 44.3 执行结果

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/50-Mybatis.png" style="zoom:67%;" />

## 45 一级缓存

### 45.1 缓存概述

用mybatis从数据库中查询数据，如果有多个用户使用同一个SQL语句来查询记录，得到相同的查询结果。

如果表中记录很多，查询速度比较慢。使用缓存的目的就是为了提升查询的速度。缓存是内存中一个区域，保存已经查询过的记录。

### 45.2 缓存分类

1. 一级缓存：使用范围是在同一个会话
2. 二级缓存：可以在不同的会话中使用

### 45.3 缓存结构

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/51-Mybatis.png" style="zoom:67%;" />

**<font color = red>一级缓存的范围：</font>**在同一个会话中使用

**需求实现**: 通过同一个 sqlSession 对象，通过id查询2次，观察发出 sql 语句的次数。

### 45.4 测试代码

```java
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
    // 5.关闭会话
    session.close();
}
```

### 45.5 执行结果

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/52-Mybatis.png" style="zoom:67%;" />

### 45.6 一级缓存的分析

1. 第1次查询记录，将查询到的数据写入到缓存中

2. 第2次查询的时候，首先从缓存中去读取数据，如果缓存中有数据，直接返回，而不去访问数据库了。

3. 如果这个会话执行了添加，修改，删除，提交，关闭清空当前会话的1级缓存。

   ​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/53-Mybatis.png" style="zoom:80%;" />

### 45.7 一级缓存的清空

清空的方式：sqlSession 执行添加、修改、删除、提交、关闭等操作，清空 sqlSession 中的一级缓存数据。

清空的目的：为了让缓存中存放最新数据，避免脏读。

### 45.8 测试代码

```java
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
```

### 45.9 执行结果

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/54-Mybatis.png" style="zoom: 80%;" />

## 46- 二级缓存

**范围**：在不同的会话中起作用

### 46.1 二级缓存(XML方式)

#### 46.1.1 \<cache>标签作用

```css
所有在映射文件里的 select 语句都将被缓存。
所有在映射文件里 insert,update 和 delete 语句会清空缓存。
缓存使用“最近很少使用”算法来回收
每个缓存可以存储 1024 个列表或对象的引用。
缓存获取的对象不是共享的且对调用者是安全的，不会有其它的调用者或线程潜在修改。
```

#### 46.1.2 实体类要序列化

```java
/**
 用户扩展信息类
 */
public class UserInfo implements Serializable{
    
}
```

#### 46.1.3 编写用户接口

```java
/**
* 查询所有的用户拓展信息
*/
List<UserInfo> findAllUserInfo();
```

#### 46.1.4 sqlMapConfig.xml

```xml
<!--开启二级缓存-->
<settings>
    <setting name="cacheEnabled" value="true"/>
</settings>
```

#### 46.1.5 创建UserMapper.xml

1. 开启二级缓存
2. 编写查询语句

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 实体类接口的类全名 -->
<mapper namespace="cn.guardwhy.dao.UserMapper">
    <!--当前的映射文件中所有的查询操作使用缓存-->
    <cache/>
    <select id="findAllUserInfo" resultType="userInfo">
        select * from user_info
    </select>
</mapper>
```

#### 46.1.6 测试代码

```java
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
```

#### 46.1.7 执行结果

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/55-Mybatis.png" style="zoom: 80%;" />

### 46.2 二级缓存(注解方式)

只需要在UserMapper接口上使用@CacheNamespace对接口中所有的查询方法使用二级缓存

#### 46.2.1 测试代码

```java
package cn.guardwhy.dao;

import cn.guardwhy.domain.OrderForm;
import cn.guardwhy.domain.User;
import cn.guardwhy.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 持久化接口:UserMapper
 */
@CacheNamespace
public interface UserMapper {

    /**
     * 查询所有的用户拓展信息
    */
    @Select("select * from user_info")
    List<UserInfo> findAllUserInfo();
}
```

#### 46.2.2 二级缓存分析

​	<img src="https://guardwhy.oss-cn-beijing.aliyuncs.com/img/javaEE/mybatis/56-Mybatis.png" style="zoom:67%;" />