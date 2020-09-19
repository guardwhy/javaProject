package cn.guardwhy_05;
/**
多态的类型转换_强制类型转换:
    父类对象或者父类类型的变量赋值给子类类型的变量必须进行强制类型转换，否则报错！
强制类型转换的格式：
 子类名称 对象名称 = (子类名称)父类对象或者父类类型的变量。

类型转换异常的问题:
 在编译阶段只要有继承关系的两个类型一定可以进行强制类型转换，编译阶段一定不会报错！！
 但是运行阶段可能出现:类型转换异常ClassCastException。类型转换异常：在运行阶段发现转型以后的类型根本不一致！！！就抛出错误！！

Java建议在进行类型转换之前先进行具体类型的判断，再强制类型转换:
 instanceof使用格式:变量instanceof类型,
 判断变量的真实类型是否是后面的类型或者后面类型的子类类型，是返回true ,不是返回false.

 小结：
 强制类型可以解决多态的劣势，可以实现访问子类的独有功能。
 */

// 基类:Animal2
class Animal2{
    public void run(){
        System.out.println("动物可以跑~~~~");
    }
}

// 派生类:Cat2
class Cat2 extends Animal2 {
    @Override
    public void run(){
        System.out.println("猫跑的贼溜~~~");
    }

    // 独有功能
    public void catchMouse(){
        System.out.println("猫抓老鼠...");
    }
}

// 派生类:Dog2
class Dog2 extends Animal2 {
    @Override
    public void run(){
        System.out.println("狗跑的贼贼快~~~");
    }

    // 独有功能
    public void lookDoor(){
        System.out.println("狗拿耗子...");
    }
}

public class PolymorphicDemo04 {
    public static void main(String[] args) {
        // 创建对象
        Animal2 as = new Cat2();
        // 对象调用方法
        as.run();
        // 强制类型转换
        Cat2 cs = (Cat2) as;
        // 对象调用方法
        cs.catchMouse();

        // 创建a1对象
        Animal2 a1 = new Dog2();
        // 强制类型转换
        Dog2 dog2 = (Dog2) a1;
        dog2.lookDoor();

        Animal2 a2 = new Dog2();
        // 判断a2的真实类型是否是Dog类型或者其子类类型。
        if(a2 instanceof Dog2){
            Dog2 d = (Dog2)a2;
            // 调用方法
            d.lookDoor();
        }else if(a2 instanceof Cat2){
            Cat2 ct = (Cat2) a2;
            ct.catchMouse();
        }
    }
}
