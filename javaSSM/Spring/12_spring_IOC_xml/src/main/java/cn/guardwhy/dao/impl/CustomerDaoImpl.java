package cn.guardwhy.dao.impl;

import cn.guardwhy.dao.CustomerDao;
import cn.guardwhy.domain.Customer;
import cn.guardwhy.resources.CustomerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
/**
 * 客户dao实现类
 */
public class CustomerDaoImpl implements CustomerDao {
    // 定义JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    // 设置方法
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查询全部客户列表
     */
    @Override
    public List<Customer> findAllCustomers() {
        // 定义sql
        String sql = "select t.cust_id, t.cust_name, t.cust_source, "+
                "t.cust_industry, t.cust_level, t.cust_address, t.cust_phone "+
                "from cst_customer t";

        // 执行查询操作
        List<Customer> list = jdbcTemplate.query(sql, new CustomerRowMapper());
        return list;
    }
}
