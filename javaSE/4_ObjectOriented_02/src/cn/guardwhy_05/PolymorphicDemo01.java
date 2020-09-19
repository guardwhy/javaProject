package cn.guardwhy_05;
/**
 面向对象的三大特征：继承，封装，多态。

 多态的形式：
     父类类名 对象名称 = new 子类构造器;
     接口名称 对象名称 = new 实现类构造器;

 父类的范围 > 子类的范围。

 多态的概念:
    同一个类型，在不同的状态下会表现出不同的行为。

 多态的识别技巧:
     对于方法的调用：编译看左边，运行看右边。
     对于变量的访问：编译看左边，运行也看左边。

 多态的的使用前提：
     1.必须有继承或者实现关系。
     2.必须有父类类型的变量引用子类类型的对象。
     3.需要存在方法重写。
*/
// 基类:Animal
class Animal{
    // 成员变量
    public String name = "动物的总称";
    // 成员方法
    public void run(){
        System.out.println("动物都能吃东西");
    }
}
// 派生类:Cat
class Cat extends Animal{
    public String name = "猫";

    @Override
    public void run() {
        System.out.println("猫在屋子吃鱼..");
    }
}
// 派生类:Dog
class Dog extends Animal{
    public String name = "狗";

    @Override
    public void run() {
        System.out.println("狗拿耗子,没有多管闲事..");
    }
}

// 测试类:
public class PolymorphicDemo01 {
    public static void main(String[] args) {
        // 父类名称 对象名称 = new 子类构造器
        Animal as1 = new Cat();
        as1.run(); // 编译看左边,运行看右边    // 猫在屋子吃鱼..
        System.out.println(as1.name); // 编译看左边,运行看左边 // 动物的总称

        // 创建对象
        Animal as2 = new Dog();
        as2.run();  // 编译看左边,运行看右边
    }
}
