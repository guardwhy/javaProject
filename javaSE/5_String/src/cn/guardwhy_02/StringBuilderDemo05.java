package cn.guardwhy_02;
/**
 * 字符串反转(升级)
 */
import java.util.Scanner;

public class StringBuilderDemo05 {
    public static void main(String[] args) {
        // 1.键盘输入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String line = sc.nextLine();

        // 调用方法,用变量接收结果
        String str = reverse(line);
        // 输出结果
        System.out.println("str字符串:" + str);
    }

    /**
     * 定义一个方法,实现字符串反转
     * @param str
     * @return
     */
    public static String reverse(String str) {
        //StringBuilder实现字符串的反转,并把结果转成String返回
        return new StringBuilder(str).reverse().toString();
    }
}
