package cn.guardwhy_04;
/***
Object类的常用方法:
(1):public String toString():
     -- 默认是返回当前对象在堆内存中的地址。
     -- 地址的格式：com.guardwhy._12bject类.Student@2ac1fdc4
     类的全限名@堆内存中的十六进制的地址。
     -- 直接输出对象，默认也是调用了toString().
     -- 在开发中，直接输出对象的地址其实是毫无意义的.
 总结：
     toString()方法默认返回对象的地址。直接输出对象可以省略toString()不写。
     toString()存在的意义是为了被子类重写，以便返回对象的数据内容。

(2):public boolean equals(Object obj)：
     -- 默认是比较两个对象的地址是否完全一样（判断是否是同一个对象）。
     -- 如果直接用equals来默认进行地址比较是否一样，那么==号完全可以替代它！
     equals存在的意义也是为了被子类重写，以便子类自己来定义比较规则。
    需求：只要两个对象的名称，年龄，性别一样我们就认为是一样的。
总结：
    equals默认比较对象的地址是否一样。
    equals存在的意义是为了被重写，以便重新定制比较规则。
    字符串的比较建议用equals，只关心内容一样就返回true.
 */
public class ObjectDemo02 {
    public static void main(String[] args) {
        // 创建学生对象
        Student s1 = new Student("curry", 10, '男');
        Student s2 = new Student("curry", 10, '男');
        // 判断对象内容是否相等
        System.out.println(s1.equals(s2));  // true
        // 判断对象地址是否相等
        System.out.println(s1 == s2);   // false

        String name1 = "guardwhy"; // 字符串变量
        String name2 = new String("guardwhy");
        // 判断对象地址值是否相等
        System.out.println(name1 == name2); // false
        // 判断对象的内容是否相等
        System.out.println(name1.equals(name2));    // true
    }
}
