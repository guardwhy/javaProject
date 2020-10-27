package cn.guardwhy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 持久层配置类
 */
public class DaoConfiguration {
    /**
     * 创建JdbcTemplate对象
     */
    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    /**
     * 创建数据源对象
     */
    @Bean("dataSource")
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
