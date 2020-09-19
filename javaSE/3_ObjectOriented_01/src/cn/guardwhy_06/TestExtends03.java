package cn.guardwhy_06;
/**
 继承后成员变量的特点:
 就近原则:子类有找子类。子类没有找父类。父类没有就报错。

 this可以用于访问当前子类对象的成员变量。
 super可以访问父类的成员变量 。
 super.父类成员变量。
 */

// 基类: Animal
class Animal{
    // 成员变量
    public String name = "动物的名称";
}

// 派生类:Dog
class Dog extends Animal{
    public String name = "狗的名称";
    // 成员方法
    public void showName(){
        String name = "局部名称";
        System.out.println(name);
        // 子类调用
        System.out.println(this.name);  // 狗的名称
        // 父类调用
        System.out.println(super.name); // 动物的名称
    }
}

// 测试类
public class TestExtends03 {
    public static void main(String[] args) {
        // 创建dog对象
        Dog dog = new Dog();
        dog.showName();
    }
}
