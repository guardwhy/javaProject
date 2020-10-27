package cn.guardwhy.dao.impl;

import cn.guardwhy.dao.CustomerDao;

/**
 * 客户dao实现类
 */
public class CustomerDaoImpl implements CustomerDao {
    // 无参构造器:BeanFactory与ApplicationContext创建对象的区别
    public CustomerDaoImpl() {
        System.out.println("正在创建CustomerDaoImpl对象");
    }

    /**
     * 初始化方法，init-method属性
     */
    public void init(){
        System.out.println("正在执行初始化操作....");
    }

    /**
     * 销毁方法:destory-method属性。
     */
    public void destroy(){
        System.out.println("正在执行销毁操作");
    }

    /**
     * 保存客户操作
     */
    @Override
    public void saveCustomer() {
        System.out.println("保存客户操作");
    }
}
