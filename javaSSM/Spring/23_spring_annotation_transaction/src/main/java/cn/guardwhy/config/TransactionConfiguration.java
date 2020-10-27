package cn.guardwhy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 事务配置类
 */
public class TransactionConfiguration {
    @Bean("transactionManager")
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource){

        // 创建事务管理器对象
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();

        // 设置数据源
        transactionManager.setDataSource(dataSource);

        return transactionManager;
    }

}
