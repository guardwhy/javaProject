package cn.guardwhy_06;

/***
 * 子类不能继承父类的东西。
 *  确定观点:子类不能继承父类的构造器。
 *
 * 有争议的观点：子类是否可以继承父类的私有成员？
 *              我认为是继承了父类的私有成员的，只是不能直接访问而已。
 * 有争议的观点：子类是否可以继承父类的静态成员？ 我认为不可以的
 *             静态的东西是可以被共享的，所以子类可以访问。共享不是继承！！
 */

// 基类:Person
class Person1{
    // 静态方法
    public static void inAddr(){
        System.out.println("curry正在大学学习汉语...");
    }

    // 成员方法
    private void run(){
        System.out.println("跑步中....");
    }
}

// 派生类:Student
class Student1 extends Person1{

}

public class TestExtends01 {
    public static void main(String[] args) throws Exception{
        // 创建对象Student
        Student1 st = new Student1();
        // 基类调用方法
        Person1.inAddr();
        // 派生类调用方法
        Student1.inAddr();
    }
}
