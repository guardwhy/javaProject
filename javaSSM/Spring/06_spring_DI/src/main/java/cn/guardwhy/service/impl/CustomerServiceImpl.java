package cn.guardwhy.service.impl;

import cn.guardwhy.dao.CustomerDao;
import cn.guardwhy.dao.impl.CustomerDaoImpl;
import cn.guardwhy.service.CustomerService;
/**
 * 客户service实现类
 */
public class CustomerServiceImpl implements CustomerService {
    // 定义客户dao
    private CustomerDao customerDao;

    /**
     * 保存客户操作
     */
    @Override
    public void saveCustomer() {
        customerDao.saveCustomer();
    }
}
