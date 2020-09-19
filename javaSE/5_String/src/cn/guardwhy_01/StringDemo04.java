package cn.guardwhy_01;

import java.util.Scanner;

/**
 *字符串遍历：public char charAt(int index):返回指定索引处的char值,字符串的索引也是从0开始的
 */
public class StringDemo04 {
    public static void main(String[] args) {
        // 键盘输入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = sc.nextLine();

        // 遍历字符串
        for(int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i));
        }
    }
}
