package cn.guardwhy_05;
/**
 多态的优势:
 （1）在多态的形势下，右边的对象可以实现组件化解耦思想。
 可以随时切换业务逻辑，而不需要更改过多代码，遍历系统的维护，拓展和管理。
 （2）实际开发的过程中，父类类型作为方法形式参数，传递子类对象给方法，进行方法的调用
 这样该方法可以接收一切子类对象的类型。更能体现出多态的扩展性与便利

 多态的劣势:
 多态形式下无法调用子类独有的功能，因为编译看左边，左边没有子类独有的功能就直接报错！！。
*/
// 基类:Animal
class Animal1{
    // 成员方法
    public void run(){
        System.out.println("动物都能吃东西");
    }
}
// 派生类:Cat
class Cat1 extends Animal1{

    @Override
    public void run() {
        System.out.println("猫在屋子里跑步..");
    }
    // 特有功能
    public void eat(){
        System.out.println("猫吃鱼...");
    }
}
// 派生类:Dog
class Dog1 extends Animal1{
    @Override
    public void run() {
        System.out.println("狗拿耗子,没有多管闲事..");
    }
}

// 测试类
public class PolymorphicDemo02 {
    public static void main(String[] args) {
        // 创建对象
        Animal1 as = new Cat1();
        // 对象调用方法
        as.run();
        // a.catchMouse(); // 多态下无法调用子类独有的功能,编译看左边

        Animal1 cs = new Cat1();
        start(cs);

        Animal1 ds = new Dog1();
        start(ds);
    }

    // 开发一个动物大赛
    public static void start(Animal1 a){
        a.run();
    }
}
