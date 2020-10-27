package cn.guardwhy.service;
/**
 * 客户service接口
 */
public interface CustomerService {
    /**
     * 保存客户
     */
    void saveCustomer();

    /**
     * 根据客户id查询客户
     */
    void findCustomerById(Integer id);
}
