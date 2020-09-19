package cn.guardwhy_05;
/**
 基类:People
 */
public class People {
    // 成员变量
    private String name;
    private int age;

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

    // 成员函数方法
    public void eat(){
        System.out.println(name + "在吃饭!!!");
    }
}
