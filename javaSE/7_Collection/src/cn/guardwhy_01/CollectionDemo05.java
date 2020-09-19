package cn.guardwhy_01;

import java.util.ArrayList;
import java.util.Collection;

/**
 Collection集合的遍历方式有三种：
 （1）迭代器
 （2）foreach遍历（增强for循环，是迭代器的简化写法）
 （3）JDK 1.8开始之后的新技术（了解）

JDK 1.8开始之后的新技术（了解）
 */
public class CollectionDemo05 {
    public static void main(String[] args) {
        // 创建一个集合对象
        Collection<String> lists = new ArrayList<>();
        // 添加元素
        lists.add("Curry");
        lists.add("Kobe");
        lists.add("James");
        lists.add("Rondo");
        System.out.println("集合元素:" + lists);    // 集合元素:[Curry, Kobe, James, Rondo]

        // 条件遍历
        System.out.println("集合forEach遍历:");
        lists.forEach(list->{
            System.out.println(list);
        });
    }
}
