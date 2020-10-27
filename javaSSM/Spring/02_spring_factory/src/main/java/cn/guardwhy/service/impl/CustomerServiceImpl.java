package cn.guardwhy.service.impl;

import cn.guardwhy.dao.CustomerDao;
import cn.guardwhy.factory.BeanFactory;
import cn.guardwhy.service.CustomerService;
/**
 * 客户service实现类
 */
public class CustomerServiceImpl implements CustomerService {
    // 从工厂类获取客户dao对象
    private CustomerDao customerDao = (CustomerDao) BeanFactory.getBeanFactory().getBean("CUSTOMERDAO");

    /**
     * 保存客户操作
     */
    @Override
    public void saveCustomer() {
        customerDao.saveCustomer();
    }
}
