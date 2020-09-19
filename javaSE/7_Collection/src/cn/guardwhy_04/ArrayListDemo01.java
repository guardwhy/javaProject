package cn.guardwhy_04;

import java.util.ArrayList;
import java.util.List;

/**
 * List系列集合有索引，所以多了很多按照索引操作元素的特有功能：
 *    - public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
 *    - public E get(int index):返回集合中指定位置的元素。
 *    - public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
 *    - public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素。
 *小结：
 *    ArrayList集合的特点：底层是基于数组存储元素的，查询性能快，增删慢
 *    开发中更多的时候在做查询，所以ArrayList集合用的最多！
 */
public class ArrayListDemo01 {
    public static void main(String[] args) {
        // 创建lists集合对象
        List<String> lists = new ArrayList<>();
        // 往集合中添加元素
        lists.add("Curry");
        lists.add("Kobe");
        lists.add("James");
        lists.add("Rondo");

        // 插入元素.在某个索引位置处插入元素,后面的元素后移
        lists.add(1, "guardwhy");
        System.out.println("list集合:" + lists);  // list集合:[Curry, guardwhy, Kobe, James, Rondo]

        // 获取索引位置的元素
        System.out.println("list集合(获取元素):" + lists.get(2)); // 获取元素:Kobe

        // 根据索引删除元素
        System.out.println(lists.remove(1));    // guardwhy
        System.out.println("list集合(删除):" + lists);  // list集合(删除):[Curry, Kobe, James, Rondo]

        // 修改某个索引位置的元素
        System.out.println(lists.set(1, "Duncan"));   // Kobe
        System.out.println("list集合(修改):" + lists);  // list集合(修改):[Curry, Duncan, James, Rondo]
    }
}
