package cn.guardwhy_03;
/**
 String类是不可变字符串。
 String类是不适合做字符串拼接的。String做字符串拼接操作性能比较差，会产生大量的垃圾对象。

 Java建议在做字符串拼接和运算的时候使用StringBuilder类/StringBuffer类。

 StringBuilder类：
     包：java.lang
     构造器：public StringBuilder(){}
     方法：
     -- public StringBuilder append(String str)：拼接字符串，依然返回当前StringBuilder对象。
总结：
     StringBuilder很适合做字符串的拼接操作，性能好，代码优雅！建议使用！
     StringBuilder线程不安全的，性能好！
     StringBuffer线程安全的，性能差！用法是完全一样的。
 */
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        // 定义字符串
        String name = "guardwhy";
        name += "is";
        name += "mvp!!!";

        // 输出字符串
        System.out.println("字符串:" + name);

        // 创建StringBuilder对象
        StringBuilder sb = new StringBuilder();
        // 拼接字符串
        sb.append("curry");
        sb.append("在nba");
        sb.append("投三分球...");
        // 输出字符串大小
        System.out.println("StringBuilder字符串:" + sb);

        // StringBuilder支持链式编程
        StringBuilder sb1 = new StringBuilder();
        sb1.append("java").append("是世界上").append("最牛逼的").append("编程语言");
        // 调用toString方法
        String st = sb1.toString();
        // 输出字符串
        System.out.println("链式编程字符串:" + st);
    }
}
