package cn.guardwhy_01;

import java.util.ArrayList;

/**
 代码块是类的五大成分之一（成员变量，构造器，方法，代码块，内部类）
 代码块按照有无static修饰可以分为静态代码块和实例代码块。

 静态代码块：
 -- 有static修饰,属于当前类本身,与类一起优先加载,加载的时候会自动执行。
     static{

     }
 -- 静态代码块的作用可以在类执行方法之前进行静态资源数据的初始化操作。
 总结：
 静态代码块可以与类一起优先加载，会自动触发执行。可以用于对静态资源进行初始化操作。
 */
public class CodeDemo01 {
    // 静态资源
    private static ArrayList lists = new ArrayList();

    // 静态代码块
    static {
        System.out.println("静态代码块被触发执行..");     // 静态代码块被触发执行..
        // 静态资源数据初始化
        lists.add("a");
        lists.add("b");
        lists.add("c");
        lists.add("d");
    }

    public static void main(String[] args) {
        System.out.println("main方法执行~~~~");    // main方法执行~~~~
        System.out.println(lists);  // [a, b, c, d]
    }
}
