package cn.guardwhy.service.impl;

import cn.guardwhy.service.CustomerService;
/**
 * 客户service实现类
 */
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void saveCustomer() {
        System.out.println("保存客户操作");
    }

    @Override
    public void findCustomerById(Integer id) {
        // 根据客户id查询客户
        System.out.println("根据客户id查询客户,客户id: " + id);
    }
}
