package cn.guardwhy.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 */
public class User implements Serializable {
    private String uname;  // 用户name
    private Integer age; // 用户gae
    private Date date; // 用户生日

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
