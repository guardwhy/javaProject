package cn.guardwhy.resources;

import cn.guardwhy.domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AccountRowMapper implements RowMapper<Account> {
    /**
     * 结果集映射的方法：
     *      结果集中的每一行记录，都会调用一次该方法
     */
    public Account mapRow(ResultSet rs, int index) throws SQLException{
        // 创建账户对象
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}
