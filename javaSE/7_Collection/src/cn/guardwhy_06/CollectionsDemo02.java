package cn.guardwhy_06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
Collections集合排序的深入：比较器的使用。

 - public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。
     此API只能针对有值特性的元素进行默认排序，整数，小数，字符串按照首字母排序。
     aaa ABBD  BBB  bC =>   ABBD BBB aaa bC

    此API无法对引用类型的元素进行排序，因为它不知道大小规则！！直接报错的！！

 - public static <T> void sort(List<T> list，Comparator<? super T> ):将集合中元
    此API可以通过定义比较器来指定引用类型元素的大小规则！！

     Comparator:比较器对象，是一个接口
     比较器的要求：如果大返回正数，如果小返回负数，如果相等返回0,元素会自动排好！！
 */
public class CollectionsDemo02 {
    public static void main(String[] args) {
        // 创建lists集合对象
        List<Student> lists = new ArrayList<>();
        // 创建学生对象
        Student stu1 = new Student("Curry", 10, '男');
        Student stu2 = new Student("Kobe", 41, '男');
        Student stu3 = new Student("Duncan", 42, '男');
        // 将学生对象添加到集合中
        Collections.addAll(lists, stu1, stu2, stu3);
        System.out.println("lists集合:" + lists);

        /**
         参数一：被排序集合
         参数二：匿名的比较器对象。
         比较器对象会自动提取集合的两两对象让程序员来定制规则排序！！
         */
        Collections.sort(lists, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println("lists集合:" + lists);
    }
}
