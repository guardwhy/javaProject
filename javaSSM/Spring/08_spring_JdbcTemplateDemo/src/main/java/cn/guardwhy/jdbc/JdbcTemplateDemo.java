package cn.guardwhy.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * spring JdbcTemplate入门案例
 */
public class JdbcTemplateDemo {
    public static void main(String[] args) {
        // 1.加载spring配置文件,创建spring IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        // 2.从spring IOC容器中,获取JdbcTemplate
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        // 3.添加账户信息
        jdbcTemplate.update("insert into account(name,money) values('Gasol',3500)");
    }
}
