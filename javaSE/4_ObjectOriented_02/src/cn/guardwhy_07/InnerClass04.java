package cn.guardwhy_07;
/**
局部内部类:
    定义在方法中，在构造器中，代码块中，for循环中定义的内部类.
局部内部类中的成分特点：
    只能定义实例成员，不能定义静态成员
    可以定义常量的。
总结：
 局部内部类几乎不用。
 */
public class InnerClass04 {
    static {
        class B{}
        abstract class C{}
    }

    public static void main(String[] args) {
        // 调用函数
        run();
        run();
    }

    public static void run(){
        class Animal{
            // 成员变量
            private String name;
            // public static int age;   // 不能定义静态成员
            // 静态常量
            public static final String SCHOOL_NAME = "中山大学商学院";

            public Animal(String name) {
                this.name = name;
            }

            // 成员函数
            public void test(){
                System.out.println("输出name:" + name);
            }
        }

        Animal a = new Animal("动物");
        a.test();
    }
}
