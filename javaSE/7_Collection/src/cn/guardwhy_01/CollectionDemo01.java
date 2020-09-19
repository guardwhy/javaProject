package cn.guardwhy_01;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
集合概念:
    集合是一个容器。容器中的每个数据称为元素。
    数组也是容器，但是数组的类型固定，定义出来以后长度也固定。
    集合的类型可以不固定，集合的大小可以随时扩容。

Java中集合的代表是：Collection类:Collection类是Java中单列集合的祖宗类。

Collection集合的体系:
                     Collection<E>(接口)
                 /                     \
         Set<E>(接口)                List<E>(接口)
         /                               /                     \
         HashSet<E>(实现类)            LinkedList<E>(实现类) ArrayList<E>(实现类)
         /
         LinkedHashSet<E>(实现类)

Collection集合体系的特点:
     Set系列集合:添加的元素，是无序，不重复，无索引的。
         -- HashSet:添加的元素，是无序，不重复，无索引的。
         -- LinkedHashSet:添加的元素，是有序，不重复，无索引的。
     List系列集合：添加的元素，是有序，可重复，有索引的。
         -- LinkedList:添加的元素，是有序，可重复，有索引的。
         -- ArrayList:添加的元素，是有序，可重复，有索引的。
总结：
 Java中集合的代表是Collection。
 Collection的功能是一切集合都可以直接使用的！！
 */
public class CollectionDemo01 {
    public static void main(String[] args) {
        // 添加元素,是无序,不重复,无索引的
        Collection<String> cs = new HashSet<>();
        // 添加元素
        cs.add("Java");
        cs.add("Java");
        cs.add("Mybatis");
        cs.add("MySQL");
        cs.add("Spring");
        cs.add("Spring");
        cs.add("SSM");
        // 输出集合元素
        System.out.println("HashSet集合元素:" + cs);

        // 添加元素,是有序,可重复,有索引的。
        Collection<String> lists = new ArrayList<>();
        // 添加元素
        lists.add("Java");
        lists.add("Java");
        lists.add("Mybatis");
        lists.add("MySQL");
        lists.add("Spring");
        lists.add("Spring");
        lists.add("SSM");
        // 输出元素集合
        System.out.println("ArrayList集合元素:" + lists);
    }
}
