package cn.guardwhy_04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 List遍历方式：
     （1）for循环
     （2）迭代器
     （3）foreach
     （4）JDK 1.8新技术。
 */
public class ArrayListDemo02 {
    public static void main(String[] args) {
        // 创建lists集合对象
        List<String> lists = new ArrayList<>();
        // 往集合中添加元素
        lists.add("Curry");
        lists.add("Kobe");
        lists.add("James");
        lists.add("Rondo");

        // 1.for循环
        System.out.println("for循环遍历:");
        for(int i=0; i<lists.size(); i++){
            System.out.println(lists.get(i));
        }
        System.out.println("++++++++++++++++");

        // 2.迭代器
        System.out.println("迭代器遍历:");
        Iterator<String> it = lists.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("++++++++++++++++");

        // foreach遍历
        System.out.println("foreach遍历:");
        for(String list : lists){
            System.out.println(list);
        }
        System.out.println("++++++++++++++++");

        // JDK 1.8新技术
        System.out.println("forEach遍历:");
        lists.forEach(list ->{
            System.out.println(list);
        });








    }
}
