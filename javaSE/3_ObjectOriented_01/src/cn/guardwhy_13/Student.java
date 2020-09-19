package cn.guardwhy_13;
/**
 *定义学生类:实现Person,law接口方法
 */
public class Student implements Person,Law{
    // 成员变量
    private String name;
    // 代参构造器
    public Student(String name) {
        this.name = name;
    }

    @Override
    public void rule() {
        System.out.println(name + "图书馆看法律书..");
    }

    @Override
    public void run() {
        System.out.println(name + "在操场跑步训练..");
    }

    @Override
    public void study() {
        System.out.println(name + "在教室准备考试...");
    }
}
