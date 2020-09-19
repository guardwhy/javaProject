package cn.guardwhy_01;
/**
 * equals方法:比较两个字符串内容是否相同、区分大小写
 */
public class StringDemo02 {
    public static void main(String[] args) {
        // 构造方法得到对象
        char[] chs = {'a', 'b','c'};
        String s1 = new String(chs);
        String s2 = new String(chs);
        // 直接赋值得到对象
        String s3 = "guardwhy";
        String s4 = "guardwhy";

        // 比较字符串对象地址是否相同
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        System.out.println("++++++++");

        // 比较字符串内容是否相同
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s3.equals(s4));
    }
}
