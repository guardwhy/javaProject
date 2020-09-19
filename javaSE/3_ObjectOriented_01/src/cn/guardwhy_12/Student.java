package cn.guardwhy_12;

public class Student implements Person{
    // 成员变量
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "需要跑步训练...");
    }

    @Override
    public void study() {
        System.out.println(name + "在学校认真学习..");
    }
}
