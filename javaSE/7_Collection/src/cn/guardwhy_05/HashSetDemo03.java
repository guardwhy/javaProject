package cn.guardwhy_05;
import java.util.HashSet;
import java.util.Set;
/**
Set系列集合元素无序的根本原因：
 Set系列集合添加元素无序的根本原因是因为底层采用了哈希表存储元素。

 JDK 1.8之前：哈希表 = 数组 + 链表  + （哈希算法）
 JDK 1.8之后：哈希表 = 数组 + 链表 + 红黑树  + （哈希算法）

总结：
     Set集合的增删改查性能都挺好的！
     缺点是：无序不重复的，无索引的。
 */
public class HashSetDemo03 {
    public static void main(String[] args) {
        Set<String> sets1 = new HashSet<>();
        // 往集合中添加元素
        sets1.add("Java");
        sets1.add("Python");
        sets1.add("Mybatis");
        sets1.add("MySQL");
        sets1.add("CSS");
        sets1.add("Java");

        System.out.println("set集合:" + sets1);   // set集合:[Java, CSS, MySQL, Mybatis, Python]
    }
}
