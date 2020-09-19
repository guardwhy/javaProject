package cn.guardwhy_06;
/**
包装类:
     Java认为一切皆对象。 类也是对象，类叫类对象。
     但是在Java中有些东西不是对象。例如8种基本数据类型不是对象。
     8种基本数据类型只是一个类型符号，Java为了一切皆对象的思想统一
     就把8种基本数据类型变成了一个类，这个类就叫做基本数据类型的包装类。

     基本数据类型              包装类
     byte                 Byte
     short                Short
     int                  Integer(特殊)
     long                 Long
     float                Float
     double               Double
     char                 Character(特殊)
     boolean              Boolean

     自动装箱：可以直接把基本数据类型的变量或者值赋值给对应的包装类对象。
     自动拆箱：可以把包装类的对象赋值给基本数据类型的变量。

总结：
     Java为了一切皆对象思想的统一，把基本数据类型都定义了一个包装类。
     互相之间是可以进行自动装箱和自动拆箱的。
 */
public class PackagingGroup01 {
    public static void main(String[] args) {
        // 自动装箱
        Integer it = 123;
        int age = 20;
        // 自动装箱
        Integer ts = age;

        // 自动拆箱
        Integer it1 = 100;
        int ts2 = it1;

        // 手工装箱
        Integer i1 = Integer.valueOf(100);
        Integer i2 = i1;
    }
}
