package cn.guardwhy.controller;

import cn.guardwhy.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户表现层
 */
public class CustomerController {
    public static void main(String[] args) {
        // 1.加载spring配置文件,创建spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        // 2.获取客户service
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        // 3.保存客户
        customerService.saveCustomer();
        // 4.根据客户id查询客户
        customerService.findCustomerById(1);
    }
}
