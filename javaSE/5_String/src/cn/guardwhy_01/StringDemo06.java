package cn.guardwhy_01;
import java.util.Scanner;
/**
 * 字符串反转
 */
public class StringDemo06 {
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
        // 倒着遍历字符串,得到每一个字符拼接成一个字符串并且返回.
        String s1 = "";
        for(int i=str.length()-1; i >= 0; i--){
            s1 += str.charAt(i);
        }
        return s1;
    }
}
