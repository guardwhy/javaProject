package cn.guardwhy_02;
/**
 final是最终的含义。final可以修饰类，方法，变量。
 final修饰类，类不能被继承了。final修饰方法，方法不能被重写。

final可以修饰变量的总规则：变量有且仅能被赋值一次。
    final可以修饰局部变量。这个变量的值被保护了,不能被修改.
    final可以修饰静态变量：成为常量值不变,只有一份,变量名称大写,下划线连接。
    final修饰静态变量可以在：静态代码块赋值一次,或者定义的时候赋值一次。

final可以修饰实例变量：
 定义的时候赋值一次,可以在实例代码块赋值一次,可以在全部构造器赋值1次。
 */
public class FinalDemo03 {
    // final常量
    private final String name1 = "中山大学医学院";
    private final String name2;
    {
        name2 = "中山大学商学院";
    }

    // 定义final name 常量
    private final String name3;

    // 无参构造器
    public FinalDemo03() {
        name3 = "中山大学工学院";
    }

    public FinalDemo03(String n) {
        name3 = "中山大学工学院";
    }

    public static void main(String[] args) {
        FinalDemo03 fs = new FinalDemo03();
        // fs.name1 = "中山大学中山医学院"; // 二次赋值,报错
        System.out.println(fs.name1);
    }
}
