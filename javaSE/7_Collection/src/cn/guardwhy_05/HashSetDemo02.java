package cn.guardwhy_05;

import java.util.HashSet;
import java.util.Set;
/**
Set系列集合元素去重复的流程:
 1.对于基本数据类型的值,Set集合可以直接判断进行去重复。
 2.对于引用数据类型的值,Set集合是按照如下流程进行是否重复的判断。

Set集合会让两两对象，先调用自己的hashCode()方法得到彼此的哈希值（所谓的内存地址）
然后比较两个对象的哈希值是否相同，如果不相同直接认为两个对象不重复。
如果相同，会继续让两个对象进行equals比较内容是否相同，如果相同认为真的重复了,如果不相同认为不重复。
         调用hashCode()方法获取两个对象的哈希值
                    /             \
                false             true
                 /                  \
             不重复               两个对象进行equals比较
                                        /        \
                                        false   true
                                         /         \
                                         不重复     重复了
总结：
 对于引用数据类型，如果希望Set集合识别是同一个对象。
 可以重写对象的hashCode和equals方法。
 */
public class HashSetDemo02 {
    public static void main(String[] args) {
        // 无序不重复无索引的
        Set<Student> sets = new HashSet<>();
        // 创建对象
        Student s1 = new Student("curry", 10 ,'男');
        Student s2 = new Student("kobe", 41 ,'男');
        Student s3 = new Student("james", 35 ,'男');
        Student s4 = new Student("rondo", 33 ,'男');
        // 添加操作
        sets.add(s1);
        sets.add(s2);
        sets.add(s3);
        sets.add(s4);
        System.out.println("set集合:" + sets);	// set集合:[Java, MySQL, Spring, Mybatis]

    }
}
