package cn.guardwhy.dao;

import cn.guardwhy.domain.Account;

/**
 * 账户dao接口
 */
public interface AccountDao {

    /**
     * 根据账户id查询账户
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据账户名称查询账户
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     */
    void updateAccount(Account account);
}
