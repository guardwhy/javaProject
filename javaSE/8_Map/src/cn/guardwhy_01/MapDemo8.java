package cn.guardwhy_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
计算一个字符串中每个字符出现次数。
 分析：
 （1）键盘录入一个字符串。  aabbccaa111
 （2）定义一个Map集合来存储最终统计的结果。键存储字符，值存储出现的次数！！
 （3）遍历字符串中的每个字符。
 （4）拿当前这个字符去Map集合看是否包含这个键，包含则其值+1
 不包含说明该字符第一次出现，直接加入“该字符=1”
 */
public class MapDemo8 {
    public static void main(String[] args) {
        // 键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String line = sc.nextLine();

        // 定义一个Map集合来存储最终统计的结果。键存储字符,值存储出现的次数
        Map<Character, Integer> infos = new HashMap<>();

        // 遍历字符串中的每个字符。
        for(int i=0; i < line.length(); i++){
            // 根据索引取当前字符
            char ch = line.charAt(i);
            // 拿当前这个字符去Map集合看是否包含这个键，包含则其值+1
            // 不包含说明该字符第一次出现，直接加入“该字符=1”
            if(infos.containsKey(ch)){
                // 这个字符之前已经统计过,其值出现的次数+1
                infos.put(ch, infos.get(ch) + 1);
            }else {
                // 这个字符是第一次出现
                infos.put(ch, 1);
            }
        }

        System.out.println("输出结果:" + infos);
    }
}
