package cn.guardwhy_02;

import java.util.ArrayList;

/**
 * ArrayList常用方法
 */
public class ArrayListTest01 {
    public static void main(String[] args) {
        // 创建集合对象
        ArrayList<String> array = new ArrayList<String>();
        // 添加元素
        array.add("hello");
        array.add("curry");
        array.add("java");

        // public boolean remove(Object o):删除指定的元素,返回删除是否成功
        /*
            System.out.println(array.remove("curry"));
            System.out.println(array.remove("java"));
        */

        // public E remove(int index):删除指定索引处的元素,返回被删除的元素
       /* System.out.println(array.remove(1));*/

        //public E set(int index,E element):修改指定索引处的元素,返回被修改的元素
        /*System.out.println(array.set(1, "guardwhy"));*/

        //public E get(int index):返回指定索引处的元素
        /*
            System.out.println(array.get(0));
            System.out.println(array.get(1));
            System.out.println(array.get(2));
        */

        // public int size():返回集合中的元素个数
        System.out.println(array.size());   // 3

        // 输出集合
        System.out.println("array集合:" + array); // array集合:[hello, curry, java]
    }
}
