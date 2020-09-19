package cn.guardwhy_07;
/**
实例内部类：
    无static修饰的内部类，属于外部类的每个对象的，与对象一起加载的。

 实例内部类的成分特点：
    不能定义静态成员(不能有静态变量和静态方法),可以定义常量。

 实例内部类创建对象的格式：
    外部类名称.内部类名称 对象名称 = new 外部类构造器.new 内部类构造器;
结论:
     实例内部类是否可以直接访问外部类的静态成员？可以的。
     实例内部类是否可以直接访问外部类的实例成员？可以的。
 */

class Outter1{
    // 成员变量
    public static int age;
    private char sex;

    // 实例内部类
    public class Inner1{
        // 成员变量
        private String name;
        // 定义静态常量
        public static final String SCHOOL_NAME = "中山大学医学院";
        // 无参构造器
        public Inner1() {
        }
        // 成员函数
        public void show(){
            System.out.println(age);
            System.out.println(sex);
        }
    }
}
public class InnerClass02 {
    public static void main(String[] args) {
        //外部类名称.内部类名称 对象名称 = new 外部类构造器.new 内部类构造器;
        Outter1.Inner1 in = new Outter1().new Inner1();
        // 调用成员函数
        in.show();
    }
}
