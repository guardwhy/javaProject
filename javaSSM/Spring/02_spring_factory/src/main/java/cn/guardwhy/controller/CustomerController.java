package cn.guardwhy.controller;

import cn.guardwhy.factory.BeanFactory;
import cn.guardwhy.service.CustomerService;

public class CustomerController {
    public static void main(String[] args) {
        // 从工厂类获取客户端service对象
        CustomerService customerService = (CustomerService) BeanFactory.getBeanFactory().getBean("CUSTOMERSERVICE");
        // 保存客户操作
        customerService.saveCustomer();
    }
}
