package cn.guardwhy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * spring配置类：
 *  注解说明：
 *      1.@Configuration：标记当前java类，是一个spring的配置类
 *      2.@ComponentScan：配置扫描包。相当于xml配置中<context:component-scan/>标签
 */
@Configuration
@ComponentScan(value = {"cn.guardwhy"})
public class SpringConfiguration {
    /**
     * <!--配置JdbcTemplate-->
     *<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
     * <!--注入数据源对象-->
     *<property name="dataSource" ref="dataSource"></property>
     *</bean>
     *
     * 说明：
     *   1.创建一个JdbcTemplate对象
     *   2.给该JdbcTemplate对象，注入一个数据源对象DataSource
     *   3.把该JdbcTemplate对象，以jdbcTemplate作为bean的名称，放入spring容器中
     *
     *   注解：
     *      @Bean：
     *          作用：把方法的返回值对象，放入spring容器中
     */
    @Bean(value = "jdbcTemplate")
    public JdbcTemplate  createJdbcTemplate(DataSource dataSource){
        // 创建JbdcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    /**
     * 配置数据源对象DateSource
     */
    @Bean(value = "dataSource")
    public DataSource createDataSource(){
        // 创建DataSource
        DruidDataSource dataSource = new DruidDataSource();
        // 注入属性
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        dataSource.setInitialSize(6);
        dataSource.setMinIdle(3);
        dataSource.setMaxActive(50);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        return dataSource;
    }

}
