package cn.guardwhy.dao.impl;

import cn.guardwhy.dao.CustomerDao;

/**
 * 客户dao实现类
 */
public class CustomerDaoImpl implements CustomerDao {

    /**
     * 增加无参构造方法
     */
    public CustomerDaoImpl() {
        System.out.println("正在创建CustomerDaoImpl对象......");
    }

    @Override
    public void saveCustomer() {
        System.out.println("保存客户操作");
    }
}
