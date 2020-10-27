package cn.guardwhy.dao.impl;

import cn.guardwhy.dao.CustomerDao;

import java.util.Date;
/**
 * 构造方法注入数据
 */
public class ConstructDaoImpl implements CustomerDao {
    // 1.类的成员变量
    private int id;
    private String name;
    private Integer age;
    private Date birthday;

    // 2.构造方法
    public ConstructDaoImpl(int id, String name, Integer age, Date birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    /**
     * 保存客户操作
     */
    public void saveCustomer() {
        System.out.println("id="+id+", name=" + name + ",age=" +age+ ",birthday=" + birthday);
    }
}
