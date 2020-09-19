package cn.guardwhy_09;
/**
抽象方法：
    有abstract修饰，只有方法签名，没有方法体。
    -- public abstract void run();
抽象类：
    有abstract修饰的。
小结:
    抽象类是知道子类一定要做某个功能，可以把该功能定义成抽象方法，然后子类重写即可。
*/

// 抽象基类:Animal
abstract class Animal{
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

    // 抽象方法
    public abstract void run(); // 有abstract修饰,只有方法签名,没有方法体。
}

// 派生类:Cat
class Cat extends Animal{
    @Override
    public void run() {
        System.out.println("猫正在抓鱼吃...");
    }
}

// 派生类:Dog
class Dog extends Animal{
    @Override
    public void run() {
        System.out.println("狗抓老鼠，没有多管闲事。。。");
    }
}

public class AbstractDemo01 {
    public static void main(String[] args) {
        // 创建派生类对象
        Dog d = new Dog();
        // 对象.方法
        d.run();
    }
}
