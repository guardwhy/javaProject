package cn.guardwhy.dao.impl;

import cn.guardwhy.dao.CustomerDao;

/**
 * 客户dao实现类
 */
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void saveCustomer() {
        System.out.println("保存客户操作");
    }
}
