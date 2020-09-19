package cn.guardwhy_01;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 Collection集合的功能:

 Collection的API:
     public boolean add(E e) ： 把给定的对象添加到当前集合中 。
     public void clear() :清空集合中所有的元素。
     public boolean remove(E e) : 把给定的对象在当前集合中删除。
     public boolean contains(Object obj) : 判断当前集合中是否包含给定的对象。
     public boolean isEmpty() : 判断当前集合是否为空。
     public int size() : 返回集合中元素的个数。
     public Object[] toArray() : 把集合中的元素，存储到数组中
 */
public class CollectionDemo02 {
    public static void main(String[] args) {
        // 创建集合对象cs
        Collection<String> cs = new HashSet<>();
        // 添加元素
        System.out.println(cs.add("Java")); // true
        System.out.println(cs.add("Java")); // false
        cs.add("MySQL");
        cs.add("MyBatis");
        // 输出集合元素
        System.out.println("集合元素:" + cs);   // 集合元素:[Java, MySQL, MyBatis]
        System.out.println("++++++++++++++++++++++++");

        // 删除元素
        System.out.println(cs.remove("MyBatis"));   // true
        System.out.println("集合元素(删除):" + cs);   // 集合元素(删除):[Java, MySQL]
        System.out.println("++++++++++++++++++++++++");

        // 判断集合中是否包含了某个元素
        System.out.println("集合是否包含该元素:");
        System.out.println(cs.contains("Java"));    // true
        System.out.println(cs.contains("Python"));  // false
        System.out.println("++++++++++++++++++++++++");

        // 判断集合是否为空,为空返回true,反之
        System.out.println("判断集合是否为空:" + cs.isEmpty());   // false
        System.out.println("++++++++++++++++++++++++");
        // 获取集合元素的个数
        System.out.println("集合元素的个数:" + cs.size());
        System.out.println("++++++++++++++++++++++++");

        // 将集合转换成数组
        Object[] objs = cs.toArray();
        System.out.println("数组内容:" + Arrays.toString(objs));
        System.out.println("++++++++++++++++++++++++");

        Collection<String> c1 = new HashSet<>();
        // 集合添加元素
        c1.add("curry");
        c1.add("james");
        Collection<String> c2 = new HashSet<>();
        // 添加元素
        c2.add("kobe");
        c2.add("Rondo");
        // 将c2全部元素倒入到c1集合中
        c1.addAll(c2);
        // 输出集合元素
        System.out.println("集合元素:" + c1);   // 集合元素:[kobe, james, Rondo, curry]
        System.out.println("++++++++++++++++++++++++");

        Collection<String> c3 = new HashSet<>();
        // 添加元素
        c3.add("Java1");
        c3.add("Java2");
        c3.add("Java");

        Collection<String> c4 = new HashSet<>();
        c4.add("Java3");
        c4.add("Java4");
        c4.add("Java");
        // c3和c4取交集，取完交集的结果作为c3的新数据！！
        c3.retainAll(c4);
        System.out.println("新集合:" + c3);    // 新集合:[Java]
    }
}
