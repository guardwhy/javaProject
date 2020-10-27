package cn.guardwhy.service.impl;

import cn.guardwhy.dao.CustomerDao;
import cn.guardwhy.domain.Customer;
import cn.guardwhy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 客户service实现类
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    // 定义客户dao
    @Autowired
    private CustomerDao customerDao;

    /**
     * 查询全部客户的列表
     */
    @Override
    public List<Customer> findAllCustomers() {
        return customerDao.findAllCustomers();
    }
}
