package cn.guardwhy_05;

import java.util.LinkedHashSet;
import java.util.Set;
/**
LinkedHashSet:元素是有序不重复，无索引.

底层依然是使用哈希表存储元素的，但是每个元素都额外带一个链来维护添加顺序！！
不光增删改查快，还有序。

总结：
     如果希望元素可以重复，又有索引，查询要快用ArrayList集合。
     如果希望元素可以重复，又有索引，增删要快询要快用LinkedList集合。
     如果希望增删改查都很快，但是元素不重复以及无序无索引，那么用HashSet集合。
     如果希望增删改查都很快且有序，但是元素不重复以及无索引，那么用LinkedHashSet集合。
 */
public class LinkedHashSetDemo04 {
    public static void main(String[] args) {
        // 创建sets集合对象
        Set<String> sets = new LinkedHashSet<>();
        // 添加元素
        sets.add("MyBatis");
        sets.add("Java");
        sets.add("MySQL");
        sets.add("Spring");
        sets.add("Java");
        // 输出集合元素
        System.out.println("LinkedHashSet集合:" + sets);  // LinkedHashSet集合:[MyBatis, Java, MySQL, Spring]
    }
}
