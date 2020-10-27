package cn.guardwhy.controller;

import cn.guardwhy.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户controller
 */
public class CustomerController {
    public static void main(String[] args) {
        /**
         使用spring框架提供的IOC容器，获取对象：
          1.spring框架提供了一个大工厂接口：ApplicationContext
          2.该工厂接口中提供了一个getBean()方法，用于根据bean的名称获取bean
          3.该工厂接口提供了常见的实现类：ClassPathXmlApplicationContext：从类路径下加载bean.xml配置文件。创建spring的ioc容器。
         */

        // 1.加载spring配置文件，创建spring ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 2.从容器中获取客户service对象
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        // 3.保存客户
        customerService.saveCustomer();
    }
}
