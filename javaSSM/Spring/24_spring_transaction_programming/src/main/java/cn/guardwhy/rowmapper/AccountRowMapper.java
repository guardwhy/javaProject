package cn.guardwhy.rowmapper;

import cn.guardwhy.domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 账户结果集映射类
 */
public class AccountRowMapper implements RowMapper<Account>{

    /**
     *每一行记录，调用一次该方法
     */
    public Account mapRow(ResultSet rs, int index) throws SQLException {

        // 创建Account
        Account account = new Account();

        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));

        return account;
    }
}
