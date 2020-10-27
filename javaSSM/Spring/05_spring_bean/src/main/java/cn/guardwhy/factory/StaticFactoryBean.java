package cn.guardwhy.factory;

import cn.guardwhy.dao.CustomerDao;
import cn.guardwhy.dao.impl.CustomerDaoImpl;

/**
 * 静态工厂方法,实例化对象
 */
public class StaticFactoryBean {
    /**
     * 静态工厂方法
     */
    public static CustomerDao createCustomerDao(){
        // 返回结果
        CustomerDao customerDao = null;
        System.out.println("静态工厂方法实例化对象---------start");
        customerDao = new CustomerDaoImpl();
        System.out.println("静态工厂方法实例化对象----------end");
        return customerDao;
    }
}
