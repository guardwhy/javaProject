package cn.guardwhy.dao.impl;

import cn.guardwhy.dao.CustomerDao;

import java.util.*;

/**
 * 集合属性成员变量赋值
 */
public class CollectionDaoImpl implements CustomerDao {
    // 集合类型成员变量
    private String[] array;
    private List<String> list;
    private Set<String> set;

    private Map<String, String> map;
    private Properties prop;

    // set方法注入
    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    /**
     * 保存客户操作
     */
    @Override
    public void saveCustomer() {
        System.out.println(array != null ? Arrays.asList(array):"");
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(prop);
    }
}
