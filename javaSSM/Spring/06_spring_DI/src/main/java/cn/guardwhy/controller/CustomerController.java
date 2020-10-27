package cn.guardwhy.controller;

import cn.guardwhy.dao.CustomerDao;
import cn.guardwhy.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户controller
 */
public class CustomerController {

    public static void main(String[] args) {
        // 1.创建spring IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 2.从容器中获取service对象
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        // 3.构造方法注入数据,保存用户
        /*CustomerDao constructDao = (CustomerDao) context.getBean("constructDao");
        constructDao.saveCustomer();*/

        // 4.set方法注入数据
        /*CustomerDao pDao = (CustomerDao) context.getBean("pDao");
        pDao.saveCustomer();*/

        // 5.c名称空间注入数据
        /*
        CustomerDao cDao = (CustomerDao) context.getBean("cDao");
        cDao.saveCustomer();
        */

        // 6.集合类型成员变量注入数剧
        CustomerDao collectionDao = (CustomerDao) context.getBean("CollectionDao");
        collectionDao.saveCustomer();
    }
}
