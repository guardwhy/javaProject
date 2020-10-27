package cn.guardwhy.jdbc;

import cn.guardwhy.domain.Account;
import cn.guardwhy.resources.AccountRowMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * spring JdbcTemplate实现完整CRUD操作
 */
public class JdbcTemplateCRUD {
    public static void main(String[] args) {
        // 1.加载spring配置文件,创建spring IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        // 2.从spring IOC容器中,获取JdbcTemplate
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        // 3.使用自定义的RowMapper
        List<Account> list = jdbcTemplate.query("select * from account", new AccountRowMapper());

        // 4.打印结果集
        for(Account account:list){
            System.out.println(account);
        }
        // 5.查询一行一列
        System.out.println("查询一行一列-------");
        Integer accountNum = jdbcTemplate.queryForObject("select count(*) from account", Integer.class);
        System.out.println("当前账户数量:" + accountNum);
    }
}
