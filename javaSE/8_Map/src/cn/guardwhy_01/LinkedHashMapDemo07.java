package cn.guardwhy_01;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 HashMap是无序不重复，无索引的，底层也是基于哈希表存储数据的，只是每个数据多了附属值。
 LinkedHashMap是有序不重复，无索引的，底层也是基于哈希表存储数据的，只是每个数据多了附属值。
 每个数据多了一个链记录添加顺序。
 覆盖：只改值！！
 */
public class LinkedHashMapDemo07 {
    public static void main(String[] args) {
        // 创建Map集合对象
        Map<String, Integer> maps = new LinkedHashMap<>();
        // 向集合中添加元素
        maps.put("小米",30);
        maps.put("huawei",10);
        maps.put("iphone11",67);
        maps.put("iphone11",80);
        maps.put("三星",45);

        // 遍历集合
        maps.forEach((k, v) ->{
            System.out.println(k + "==>" + v);
        });

        // 输出结果
        /*
            小米==>30
            huawei==>10
            iphone11==>80
            三星==>45
        */
    }
}
