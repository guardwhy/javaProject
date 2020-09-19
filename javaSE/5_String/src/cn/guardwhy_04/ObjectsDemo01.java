package cn.guardwhy_04;

import java.util.Objects;

/**
 从JDK 1.7开始的新类。

 Objects类与Object没有直接联系,只是名字很像而已。
 Objects类继承了Object类。

 Objects类提供了2个功能:
     1.public static boolean equals(Object a, Object b)`:判断两个对象的地址是否相等。
         public static boolean equals(Object a, Object b) {
                return (a == b) || (a != null && a.equals(b));
         }
     可以避免空指针异常！建议使用!!
    2.public static boolean isNull(Object obj) 判断对象是否为null，如果为null返回true。
 */
public class ObjectsDemo01 {
    public static void main(String[] args) {
        // 定义字符串变量
        String name1 = null;
        // 空指针异常
        // System.out.println(name1.equals("guardwhy"));

        String name2 = null;
        // false:比较结果都是一样的,但是这里是不会出现空指针异常，内部已经过滤了。
        System.out.println(Objects.equals(name2,"guardwhy"));   // false

        // 2.判断对象是否null,为null返回true,反之..
        String name3 = null;
        System.out.println(Objects.isNull(name3));  // true
        System.out.println(name3 == null);  // true
    }
}
