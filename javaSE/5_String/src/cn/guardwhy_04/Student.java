package cn.guardwhy_04;

import java.util.Objects;

public class Student {
    // 成员变量
    private String name;
    private int age;
    private char sex;

    // 无参构造器
    public Student() {
    }

    // 代参构造器
    public Student(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    // set.get方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    // toString方法
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    // 比较者:this 被比较者:o
    @Override
    public boolean equals(Object o) {
        // 1.判断是否是同一个对象比较，判断是否自己与自己比较。
        if (this == o) return true;
        // 2.判断o类型是否是学生类型，以及是否为null
        if (o == null || getClass() != o.getClass()) return false;
        // 3.o一定是学生类型了！！判断内容是否一样！！
        Student student = (Student) o;
        return age == student.age &&
                sex == student.sex &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }
}
