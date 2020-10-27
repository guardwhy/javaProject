package cn.guardwhy.controller;

import cn.guardwhy.service.CustomerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户controller
 */
public class CustomerController {
    public static void main(String[] args) {
        // 1.加载spring配置文件,创建spring ioc容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 2.实例工厂方法实例化对象
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        // 3.保存用户
        customerService.saveCustomer();
        // 4.销毁容器
        context.close();
    }
}
