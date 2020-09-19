package cn.guardwhy_06;
/**
 继承后成员方法的特点
 就近原则：子类有找子类,子类没有找父类,父类没有就报错了
*/

// 基类:Animal1
class Animal1{
    // 成员方法
    public void run(){
        System.out.println("动物可以跑步..");
    }

    public void eat(){
        System.out.println("动物吃东西..");
    }
}

// 派生类:Cat
class Cat extends Animal1{
    @Override
    // 方法重写
    public void run() {
        super.run();
        System.out.println("猫抓老鼠跑的很快...");
    }
}

// 测试类
public class TestExtends04 {
    public static void main(String[] args) {
        // 创建cat对象
        Cat cs = new Cat();
        // 派生类
        cs.run();
        // 基类
        cs.eat();
    }
}
