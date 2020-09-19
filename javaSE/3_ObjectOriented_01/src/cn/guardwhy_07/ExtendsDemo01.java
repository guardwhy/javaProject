package cn.guardwhy_07;
/**
 * 继承后构造器的特点:
 * 子类的全部构造器,一定会先调用父类的无参数构造器,再执行自己。
 * 结论:
 *  子类的构造器一定会先调用父类的无参数构造器再执行自己。
 *  子类的构造器的第一行默认有一个super()调用父类的无参数构造器.
*/

// 基类:Animal
class Animal{
    public Animal(){
        System.out.println("父类Animal无参数构造器..");
    }
}

// 派生类:Dog
class Dog extends Animal{
    public Dog(){
        super(); // 调用父类无参数构造器,不管是否有写,默认都存在。
        System.out.println("子类Dog无参数构造器...");
    }

    public Dog(String name){
        super();
        System.out.println("子类Dog有参构造器...");
    }
}

// 测试类
public class ExtendsDemo01 {
    public static void main(String[] args) {
        new Dog("藏獒");
    }
}
