package cn.guardwhy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 主配置类步骤：
 *      1.使用@Configuration注解，声明主配置类
 *      2.使用@ComponentScan注解，扫描注解配置
 *      3.使用@Import注解，导入其它模块配置类
 *      4.使用@EnableTransactionManagement注解，启用spring对注解事务的配置
 */
@Configuration
@ComponentScan(value="cn.guardwhy")
@Import(value={DaoConfiguration.class,TransactionConfiguration.class})
@EnableTransactionManagement
public class SpringConfiguration {
}
