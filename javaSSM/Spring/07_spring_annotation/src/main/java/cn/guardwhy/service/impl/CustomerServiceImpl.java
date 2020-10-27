package cn.guardwhy.service.impl;

import cn.guardwhy.dao.CustomerDao;
import cn.guardwhy.dao.impl.CustomerDaoImpl;
import cn.guardwhy.service.CustomerService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 /**
 * 客户service实现类：
 */
@Service("customerService")
@Scope(value = "singleton")
public class CustomerServiceImpl implements CustomerService {
    // 定义客户dao
    // @Resource(name="customerDao")
    @Resource(type = CustomerDaoImpl.class)
    private CustomerDao customerDao;

    // 2.简单类型成员变量
    @Value("1")
    private int id;
    @Value("小明")
    private String name;

    // 初始化操作
    @PostConstruct
    public void init(){
        System.out.println("正在执行初始化操作");
    }

    // 销毁操作
    @PreDestroy
    public void destroy(){
        System.out.println("正在执行销毁操作....");
    }

    /**
     * 保存客户操作
     */
    @Override
    public void saveCustomer() {
        System.out.println("id="+id+",name="+name);
        customerDao.saveCustomer();
    }
}
