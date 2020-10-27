package cn.guardwhy.service.impl;

import cn.guardwhy.dao.AccountDao;
import cn.guardwhy.domain.Account;
import cn.guardwhy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 账户service实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService{

    // 定义账户dao
    @Autowired
    private AccountDao accountDao;

    // 定义事务管理模板
    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
     * 根据账户id查询账户
     *
     * @param accountId
     */
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    /**
     * 转账操作:
     * 参数说明：
     * sourceName：转出账户
     * destName：转入账户
     * money：转账金额
     * @param sourceName
     * @param destName
     * @param money
     */
    public void transfer(final String sourceName, final String destName, final Float money) {
        // 定义事务回调对象
        TransactionCallbackWithoutResult tcwr = new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                // 1.查询转出账户
                Account sourceAccount = accountDao.findAccountByName(sourceName);
                // 2.查询转入账户
                Account destAccount = accountDao.findAccountByName(destName);
                // 3.转出账户-money
                sourceAccount.setMoney(sourceAccount.getMoney()-money);
                // 4.转入账户+money
                destAccount.setMoney(destAccount.getMoney()+money);
                // 5.更新转出账户
                accountDao.updateAccount(sourceAccount);
                // 6.更新转入账户
                accountDao.updateAccount(destAccount);
            }
        };

        // 使用事务模板执行
        transactionTemplate.execute(tcwr);
    }
}
