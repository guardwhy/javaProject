package cn.guardwhy.service.impl;

import cn.guardwhy.dao.CustomerDao;
import cn.guardwhy.domain.Customer;
import cn.guardwhy.service.CustomerService;

import java.util.List;
/**
 * 客户service实现类
 */
public class CustomerServiceImpl implements CustomerService {
    // 定义客户dao
    private CustomerDao customerDao;

    // 设置方法
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * 查询全部客户的列表
     */
    @Override
    public List<Customer> findAllCustomers() {
        return customerDao.findAllCustomers();
    }
}
