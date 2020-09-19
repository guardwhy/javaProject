package cn.guardwhy_03;

/**
 * 标准类
 */
public class Student {
    // 成员变量
    private String name;
    private int age;

    // 构造函数
    public Student(){

    }

    // 代参构造
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * get/set方法
     * @return
     */
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

    /**
     * 成员函数
     */
    public void display(){
        System.out.println(name + "," + age);
    }
}
