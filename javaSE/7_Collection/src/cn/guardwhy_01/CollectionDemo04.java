package cn.guardwhy_01;

import java.util.ArrayList;
import java.util.Collection;

/**
Collection集合的遍历方式有三种：
 （1）迭代器
 （2）foreach遍历（增强for循环，是迭代器的简化写法）
 （3）JDK 1.8开始之后的新技术（了解）

foreach遍历，可以遍历集合也可以遍历数组，是迭代器的简化写法
    foreach遍历的核心是记住格式:
         for(被遍历集合或者数组中元素的类型 变量名称 : 被遍历集合或者数组){

         }

总结:foreach遍历原理就是迭代器,写法是简化写法。
 */
public class CollectionDemo04 {
    public static void main(String[] args) {
        // 创建一个集合对象
        Collection<String> lists = new ArrayList<>();
        // 添加元素
        lists.add("Curry");
        lists.add("Kobe");
        lists.add("James");
        lists.add("Rondo");
        System.out.println("集合元素:" + lists);    // 集合元素:[Curry, Kobe, James, Rondo]

        System.out.println("集合for_each遍历:");
        for(String list : lists){
            System.out.println(list);
        }

        // 数组遍历
        int[] arrs = {10, 20, 30, 40};
        System.out.print("数组元素:");
        for(int arr : arrs){
            System.out.print(" " + arr);
        }
    }
}
