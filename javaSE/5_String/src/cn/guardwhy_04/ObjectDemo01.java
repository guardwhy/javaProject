package cn.guardwhy_04;
/***
 Object类是Java中的祖宗类，一个类要么默认继承了Object，要么间接继承了Object类。
 Object类的作用？
     Object是祖宗类，所以Object类中的方法功能是Java中所有类都可以直接使用的。
     因为所有类都继承了Object类。

 Object类的常用方法:
     （1）public String toString():
     -- 默认是返回当前对象在堆内存中的地址。
     类的全限名@堆内存中的十六进制的地址。
     -- 直接输出对象，默认也是调用了toString().
     -- 在开发中，直接输出对象的地址其实是毫无意义的，
 总结:
     toString()方法默认返回对象的地址。
     直接输出对象可以省略toString()不写。
     toString()存在的意义是为了被子类重写，以便返回对象的数据内容。

     （2）public boolean equals(Object obj)：
 */
public class ObjectDemo01 {
    public static void main(String[] args) {
        Student stu = new Student("curry", 10, '男');
        // 默认是返回当前对象在堆内存中的地址。
        // System.out.println(stu.toString());
        // 直接输出对象，默认也是调用了toString()
        System.out.println(stu);
    }
}
