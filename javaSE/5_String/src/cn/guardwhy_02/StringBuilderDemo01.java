package cn.guardwhy_02;
/**
 * StringBuilder类的构造方法
 */
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //public StringBuilder():创建一个空白可变字符串对象,不含有任何内容
        StringBuilder sb1 = new StringBuilder();
        System.out.println("sb1字符串:" + sb1);
        System.out.println("sb1的长度:" + sb1.length());

        //public StringBuilder(String str):根据字符串的内容,来创建可变字符串对象
        StringBuilder sb2 = new StringBuilder("guardwhy");
        System.out.println("sb2的字符串:" + sb2);
        System.out.println("sb2的长度:" + sb2.length());
    }
}
