package cn.guardwhy_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
常见的运行时异常:
 运行时异常: 继承自RuntimeException的异常或者其子类，编译阶段是不会出错的.
 它是在运行时阶段可能出现的错误，运行时异常编译阶段可以处理也可以不处理，编译阶段是不会出错的。

 1.数组索引越界异常:ArrayIndexOutOfBoundsException
 2.空指针异常 : NullPointerException
 直接输出没有问题。但是调用空指针的变量的功能就会报错！！
 3.类型转换异常：ClassCastException
 4.迭代器遍历没有此元素异常：NoSuchElementException
 5.数学操作异常：ArithmeticException
 6.数字转换异常： NumberFormatException

 总结：
 运行时异常都是继承自RuntimeException，编译阶段不会报错，运行时才会出现。
 异常一旦出现了，假如没有处理，程序会立即在出现异常的地方死亡.
 */
public class ExceptionDemo02 {
    public static void main(String[] args) {
        System.out.println("程序开始...");
        // 1.数组索引越界异常:ArrayIndexOutOfBoundsException
        int[] arr1 = {10, 20, 30};
        // 输出数组元素
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr1[2]);
        // System.out.println(arr1[3]); // 数组越界

        // 2.空指针异常:NullPointerException
        String name = null;
        System.out.println(name);   // 空指针直接输出没有问题,直接输出没有地址的类型:null.
        // System.out.println(name.length());

        // 3.类型转换异常：ClassCastException
        Object obj = "guardwhy";
        // Integer it = (Integer) obj;

        // 4.迭代器遍历没有此元素异常：NoSuchElementException
        List<String> lists = new ArrayList<>();
        // 添加集合元素
        Collections.addAll(lists, "java","python", "cpp");
        Iterator<String> it = lists.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        // System.out.println(it.next());   // 元素异常..

        // 5.数学操作异常：ArithmeticException
        /*
            int c = 10 / 0;
            System.out.println(c);
        */

        // 6.数字转换异常:NumberFormatException
        String num = "12guardwhy";
        // int n = Integer.valueOf(num);
        // System.out.println(n);
        System.out.println("程序结束....");
    }
}
