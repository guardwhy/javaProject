package cn.guardwhy_06;
/**
 * 继承后成员变量的特点:
 * 就近原则:子类有找子类,子类没有找父类。父类没有就报错。
 */

// 基类:Person2
class Person2{
    // 成员变量
    public String name1 = "Person的姓名1";
    public String name2 = "Person的姓名2";
}

// 派生类:Student2
class Student2 extends Person2{
    public String name = "Student的姓名";
}

public class TestExtends02 {
    public static void main(String[] args) {
        // 创建Student2对象
        Student2 st2 = new Student2();
        // 调用派生类成员变量
        System.out.println(st2.name);
        // 调用基类成员变量
        System.out.println(st2.name1);
        System.out.println(st2.name2);
    }
}
