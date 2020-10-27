package cn.guardwhy.factory;

import cn.guardwhy.dao.CustomerDao;
import cn.guardwhy.dao.impl.CustomerDaoImpl;

/**
 * 实例工厂方法
 */
public class InstanceFactoryBean {
    // 工厂方法
    public CustomerDao createCustomerDao(){
        // 1.返回结果
        CustomerDao customerDao = null;
        System.out.println("实例工厂方法实例化对象--------start");
        customerDao = new CustomerDaoImpl();
        System.out.println("实例工厂方法实例化对象--------end");
        return customerDao;
    }
}
