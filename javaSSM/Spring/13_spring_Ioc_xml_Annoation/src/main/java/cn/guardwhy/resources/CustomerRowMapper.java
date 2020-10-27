package cn.guardwhy.resources;

import cn.guardwhy.domain.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerRowMapper implements RowMapper<Customer> {
    /**
     * 结果集映射的方法：
     *      结果集中的每一行记录，都会调用一次该方法
     */
    public Customer mapRow(ResultSet rs, int index) throws SQLException{
        // 创建客户对象
        Customer customer = new Customer();
        customer.setCustId(rs.getLong("cust_id"));
        customer.setCustName(rs.getString("cust_name"));
        customer.setCustSource(rs.getString("cust_source"));
        customer.setCustIndustry(rs.getString("cust_industry"));
        customer.setCustLevel(rs.getString("cust_level"));
        customer.setCustAddress(rs.getString("cust_address"));
        customer.setCustPhone(rs.getString("cust_phone"));
        return customer;
    }
}
