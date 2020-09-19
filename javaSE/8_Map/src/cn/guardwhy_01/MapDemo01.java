package cn.guardwhy_01;

import java.util.HashMap;
import java.util.Map;

/**
 Map集合概述:
     Map集合是一种双列集合，每个元素包含两个值。
     Map集合的每个元素的格式：key=value(键值对元素)。
     Map集合也被称为键值对集合。

 Map集合是另一个集合体系。Collection是单值集合体系。
 Map集合的完整格式：{key1=value1 , key2=value2 , key3=value3 , ...}

Map集合的体系：
     Map<K , V>(接口)
     |
     HashMap<K , V>(实现类,经典)
     |
     LinkedHashMap<K, V>(实现类)

Map集合的特点：
     1.Map集合的特点都是由键决定的。
     2.Map集合的键是无序不重复的，无索引的。
     Map集合后面重复的键对应的元素会覆盖前面的整个元素！
     3.Map集合的值无要求。
     4.Map集合的键值对都可以为null。
 */
public class MapDemo01 {
    public static void main(String[] args) {
        // 创建Map集合对象
        Map<String, Integer> shopCars = new HashMap<>();
        // 向集合中添加元素
        shopCars.put("小米",10);
        shopCars.put("小米",30); // 键重复了，后面的覆盖前面的整个元素
        shopCars.put("huawei",1000);
        shopCars.put("iphone11",1);
        shopCars.put("iphone11",2);
        shopCars.put("三星",2);
        shopCars.put(null,null);

        // 输出map集合
        System.out.println("map集合:" + shopCars);  // map集合:{null=null, huawei=1000, iphone11=2, 小米=30, 三星=2}
    }
}
