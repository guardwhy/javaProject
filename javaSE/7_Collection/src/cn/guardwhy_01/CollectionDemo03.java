package cn.guardwhy_01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 Collection集合的遍历方式是所有集合都可以使用的。
 因为Collection集合是根类，他的功能子类都可以直接使用。

 Collection集合的遍历方式有三种：
 （1）迭代器
 （2）foreach遍历（增强for循环，是迭代器的简化写法）
 （3）JDK 1.8开始之后的新技术
 1.迭代器遍历集合元素：
 步骤：
     -- 先获取集合的迭代器对象。
     方法：Iterator<E> iterator():得到当前集合的迭代器对象
     代码：Iterator<String> it = names.iterator();
     -- 使用while循环通过it.hasNext()询问是否有下一个元素。
     有就返回true然后进入循环通过it.next取出下一个元素。没有返回false ,循环就结束了!!
 注意：迭代器不能通过next()去访问超过了最大个数的元素.
 */
public class CollectionDemo03 {
    public static void main(String[] args) {
        // 创建一个集合对象
        Collection<String> lists = new ArrayList<>();
        // 添加元素
        lists.add("Curry");
        lists.add("Kobe");
        lists.add("James");
        lists.add("Rondo");
        System.out.println("集合元素:" + lists);    // 集合元素:[Curry, Kobe, James, Rondo]

        // 先获取当前集合的迭代器对象
        Iterator<String> it = lists.iterator();
        // 遍历迭代器对象
        System.out.println("迭代器遍历:");
        while (it.hasNext()){
            String str = it.next();
            // 输出集合元素
            System.out.println(str);
        }
    }
}
