package cn.guardwhy_04;

import java.util.LinkedList;

/**
 目标：LinkedList集合。
 LinkedList也是List的实现类：底层是基于链表的，增删比较快，查询慢！！
 LinkedList是支持双链表，定位前后的元素是非常快的，增删前后的元素也是最快的
 所以LinkedList多了很多操作首尾元素的特殊功能：
     - public void addFirst(E e):将指定元素插入此列表的开头。
     - public void addLast(E e):将指定元素添加到此列表的结尾。
     - public E getFirst():返回此列表的第一个元素。
     - public E getLast():返回此列表的最后一个元素。
     - public E removeFirst():移除并返回此列表的第一个元素。
     - public E removeLast():移除并返回此列表的最后一个元素。
     - public E pop():从此列表所表示的堆栈处弹出一个元素。
     - public void push(E e):将元素推入此列表所表示的堆栈。

总结：
 如果查询居多的操作选择用ArrayList集合。（用的最多）
 如果经常要操作首尾元素的增删等用LinkedList。
 */
public class LinkedListDemo03 {
    public static void main(String[] args) {
        // 创建queue对象
        LinkedList<String> queue = new LinkedList<>();
        // 做队列,入队操作
        queue.addLast("Curry");
        queue.addLast("kobe");
        queue.addLast("James");
        queue.addLast("Rondo");

        // 出队操作
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println("队列集合:" + queue);    // 队列集合:[James, Rondo]

        // 做栈操作
        LinkedList<String> stack = new LinkedList<>();
        // 入栈操作,压栈
        stack.push("Curry");
        stack.push("Kobe");
        stack.push("James");
        stack.push("Rondo");
        stack.push("Duncan");

        // 出栈操作
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("栈集合:" + stack);     // 栈集合:[Kobe, Curry]
    }
}
