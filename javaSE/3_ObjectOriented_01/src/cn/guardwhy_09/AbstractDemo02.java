package cn.guardwhy_09;
/**
 抽象类的使用：
 一个类继承了抽象类，必须重写完抽象类的全部抽象方法，否则这个类也必须定义抽象类。
*/

// 抽象基类:Animal
abstract class Animal1{
    // 成员变量
    private String name;
    // 抽象方法
    public abstract void run();
    public abstract void eat();

    // get.set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 派生类:Dog1
class Dog1 extends Animal1{

    @Override
    public void run() {
        System.out.println("狗拿耗子,多管闲事...");
    }

    @Override
    public void eat() {
        System.out.println("狗吃骨头..");
    }
}

public class AbstractDemo02 {
    public static void main(String[] args) {
        // 创建对象
        Dog1 dog1 = new Dog1();
        // 对象调用抽象方法
        dog1.run();
        dog1.eat();
    }
}
