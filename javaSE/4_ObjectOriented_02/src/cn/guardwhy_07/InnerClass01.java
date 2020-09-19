package cn.guardwhy_07;
/**
什么是静态内部类？
        使用了static修饰的内部类，属于外部类本身，会与外部类加载一次，只有一份。
静态内部类的成分特点：
    类有的成分它都具备，它只是位置在一个类的里面而已，而且只有一份，所以去普通类几乎无任何差别。
静态内部类的访问格式：
    外部类名称.内部类名称 （外部类==宿主，内部类==寄生）
静态内部类创建对象的格式：
    外部类名称.内部类名称 对象名称 = new 外部类名称.内部类构造器;
总结：
 静态内部类是否可以直接访问外部类的静态成员？可以的 ,外部类的静态成员可以被共享。
 静态内部类是否可以直接访问外部类的实例成员？不可以的 ,外部类的实例成员必须用外部类对象访问。
 */

class Outter{
    // 静态变量
    public static int age = 10;
    // 成员变量
    private char sex;
    // 静态内部类
    public static class Inner{
        // 成员变量
        private String name;
        // 静态变量
        public static String schoolName = "中山大学医学院";

        // 打印元素
        public void show(){
            System.out.println(age);
        }

        // 无参构造器
        public Inner() {

        }
        // 代参构造器
        public Inner(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
public class InnerClass01 {
    public static void main(String[] args) {
        // 创建对象
        Outter.Inner in = new Outter.Inner();
        in.show();  // 10
    }
}
