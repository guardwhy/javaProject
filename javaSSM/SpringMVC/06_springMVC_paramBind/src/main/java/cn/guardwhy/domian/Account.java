package cn.guardwhy.domian;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 账户类
 */
public class Account implements Serializable {
    private String username; //姓名
    private String password; // 密码
    private Double money;   // 金额

    private List<User> list; // 用户list集合
    private Map<String, User> map; // 用户Map集合

    // set.get方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
