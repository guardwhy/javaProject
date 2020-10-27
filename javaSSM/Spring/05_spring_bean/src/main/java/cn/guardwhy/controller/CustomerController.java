package cn.guardwhy.controller;

import cn.guardwhy.dao.CustomerDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户controller
 */
public class CustomerController {
    public static void main(String[] args) {
        // 1.创建spring IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 2.实例工厂方法实例化对象
        CustomerDao instanceDao = (CustomerDao) context.getBean("instanceDao");
        // 3.保存用户
        instanceDao.saveCustomer();
    }
}
