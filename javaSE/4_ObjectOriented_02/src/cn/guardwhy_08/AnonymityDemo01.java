package cn.guardwhy_08;
/**
 匿名内部类:是一个没有名字的局部内部类。
 匿名内部类的作用:为了简化代码！！

 匿名内部类的格式:
     new 类名|接口|抽象类(形参值){
     进行方法重写。
     }

 匿名内部类的特点：
     匿名内部类是一个没有名字的特殊类。
     匿名内部类一旦写出来了，会自动创建一个匿名内部类的对象。
     匿名内部类创建出来的对象的类型相当于继承了Animal类型。
总结：
     匿名内部类是一种没有名字的局部内部类，写出来就自动创建了对象。
     匿名内部类是为了简化代码。
     匿名内部类返回的对象的类型就是当前new的那个类型。
*/
abstract class Animal{
    // 抽象方法
    public abstract void run();
    // 成员函数
    public void test(){}
}

public class AnonymityDemo01 {
    public static void main(String[] args) {
        new Animal(){
            @Override
            public void run() {
                System.out.println("猫跑的很快....");
                // 调用函数
                test();
            }

        }.run();
    }
}
