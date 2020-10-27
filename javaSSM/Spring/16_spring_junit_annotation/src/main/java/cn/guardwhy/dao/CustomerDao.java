package cn.guardwhy.dao;

import cn.guardwhy.domain.Customer;

import java.util.List;

public interface CustomerDao {
    /**
     * 查询全部客户
     */
    List<Customer> findAllCustomers();
}
