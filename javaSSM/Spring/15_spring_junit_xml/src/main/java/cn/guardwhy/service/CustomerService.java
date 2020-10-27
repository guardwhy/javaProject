package cn.guardwhy.service;

import cn.guardwhy.domain.Customer;

import java.util.List;
/**
 * 客户service接口
 */
public interface CustomerService {
    /**
     * 查询全部客户列表
     */
    List<Customer> findAllCustomers();
}
