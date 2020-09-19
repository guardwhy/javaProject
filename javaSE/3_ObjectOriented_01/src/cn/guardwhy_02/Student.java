package cn.guardwhy_02;
/**
 * 学生类:private关键字
 */
public class Student {
    // 成员变量
    private String name;
    private int age;

    // 构造方法
    public Student() {
        this.name = name;
        this.age = age;
    }

    /**
     * get/set方法
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * 成员函数
     */
    public void display(){
        System.out.println(name + "," + age);
    }
}
