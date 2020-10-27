package cn.guardwhy.dao.impl;

import cn.guardwhy.dao.CustomerDao;

/**
 * 客户dao实现类
 */
public class CustomerDaoImpl implements CustomerDao {
    /**
     * 初始化方法
     */
    public void init(){
        System.out.println("正在执行初始化操作......");
    }

    /**
     * 销毁方法
     */
    public void destroy(){
        System.out.println("正在执行销毁操作......");
    }

    /**
     * 无参数构造方法
     */
    public  CustomerDaoImpl(){
        System.out.println("正在创建客户CustomerDaoImpl对象.");
    }

    /**
     * 保存客户
     */
    public void saveCustomer() {
        System.out.println("保存客户。");
    }
}
