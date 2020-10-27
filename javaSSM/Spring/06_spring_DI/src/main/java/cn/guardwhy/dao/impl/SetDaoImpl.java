package cn.guardwhy.dao.impl;

import cn.guardwhy.dao.CustomerDao;

import java.util.Date;

/**
 * set方法注入数据
 */
public class SetDaoImpl implements CustomerDao {
    // 1.类的成员变量
    private int id;
    private String name;
    private Integer age;
    private Date birthday;

    // 2.set方法
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 保存客户操作
     */
    @Override
    public void saveCustomer() {
        System.out.println("id="+id+", name=" + name + ",age=" +age+ ",birthday=" + birthday);
    }
}
