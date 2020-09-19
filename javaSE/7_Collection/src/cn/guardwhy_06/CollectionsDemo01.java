package cn.guardwhy_06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 Collections是集合工具类是用来操作集合的。
 Collections并不是集合，只是操作集合的一个工具API。

 Collections集合的常用方法：
     - public static <T> boolean addAll(Collection<? super T> c, T... elements)
     为任何类型的集合批量添加元素
     - public static void shuffle(List<?> list) :打乱集合顺序。
     - public static <T> void sort(List<T> list) :将集合中元素按照默认规则排序。
     - public static <T> void sort(List<T> list，Comparator<? super T> )`:将集合中元素按照指定规则排序。
 */
public class CollectionsDemo01 {
    public static void main(String[] args) {
        // 创建一个集合对象
        Collection<String> lists1 = new ArrayList<>();

        /**
         1.给集合批量添加元素
         参数一：被添加元素的集合对象。
         参数二：添加的元素值（可以批量写）
         */
        Collections.addAll(lists1, "curry", "kobe", "james", "rondo");
        System.out.println("集合元素:" + lists1);    // 集合元素:[curry, kobe, james, rondo]

        /**
         2.打乱List集合的顺序
         public static void shuffle(List<?> list):只能打乱List集合的顺序！！
         */

        // 创建list2对象
        List<String> lists2 = new ArrayList<>();
        Collections.addAll(lists2, "curry", "kobe", "james", "rondo");
        Collections.shuffle(lists2);
        System.out.println("集合元素:" + lists2);   // 集合元素:[rondo, curry, kobe, james]

        /**
         3.给List集合的元素进行默认的升序排序
         只支持List集合
         */
        List<Integer> lists3 = new ArrayList<>();
        // 添加集合元素
        lists3.add(22);
        lists3.add(2);
        lists3.add(232);
        lists3.add(287);
        lists3.add(87);
        System.out.println("集合元素(排序前):" + lists3);   // 集合元素(排序前):[22, 2, 232, 287, 87]
        // 集合排序
        Collections.sort(lists3);
        System.out.println("集合元素(排序后):" + lists3);  // 集合元素(排序后):[2, 22, 87, 232, 287]
    }
}
