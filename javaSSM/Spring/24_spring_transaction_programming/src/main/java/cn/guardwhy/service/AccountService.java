package cn.guardwhy.service;

import cn.guardwhy.domain.Account;

/**
 * 账户service接口
 */
public interface AccountService {

    /**
     * 根据账户id查询账户
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账操作:
     *  参数说明：
     *      sourceName：转出账户
     *      destName：转入账户
     *      money：转账金额
     */
    void transfer(String sourceName,String destName,Float money);
}
