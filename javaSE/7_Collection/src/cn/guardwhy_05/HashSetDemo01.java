package cn.guardwhy_05;

import java.util.HashSet;
import java.util.Set;

/**
 HashSet集合:
     Collection集合的体系:
					Collection<E>(接口)
			/                          		\
         Set<E>(接口)                      List<E>(接口)
         /                                 /         			\               \
         HashSet<E>(实现类)       LinkedList<E>(实现类) Vector(线程安全)     ArrayList<E>(实现类)
         /
         LinkedHashSet<E>(实现类)

 Collection集合体系的特点:
         Set系列集合： 添加的元素，是无序，不重复，无索引的。
             -- HashSet：添加的元素，是无序，不重复，无索引的。
             -- LinkedHashSet：添加的元素，是有序，不重复，无索引的。
         List系列集合：添加的元素，是有序，可重复，有索引的。
             -- LinkedList： 添加的元素，是有序，可重复，有索引的。
             -- ArrayList： 添加的元素，是有序，可重复，有索引的。
 */
public class HashSetDemo01 {
	public static void main(String[] args) {
		// 无序不重复无索引的
		Set<String> sets = new HashSet<>();
		// 往集合中添加元素
		sets.add("Java");
		sets.add("Java");
		sets.add("Mybatis");
		sets.add("MySQL");
		sets.add("MySQL");
		sets.add("Spring");

		System.out.println("set集合:" + sets);	// set集合:[Java, MySQL, Spring, Mybatis]

	}
}
