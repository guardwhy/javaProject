package cn.guardwhy.controller;

import cn.guardwhy.domain.Customer;
import cn.guardwhy.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 客户表现层
 */
public class CustomerController {
    public static void main(String[] args) {
        // 1.加载spring配置文件,创建spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        // 2.获取客户service对象
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        // 3.查询全部客户列表数据
        List<Customer> list = customerService.findAllCustomers();
        // 4.遍历操作
        for(Customer customer : list){
            System.out.println(customer);
        }
    }
}
