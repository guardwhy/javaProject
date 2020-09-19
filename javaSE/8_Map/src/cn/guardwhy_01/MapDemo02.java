package cn.guardwhy_01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 Map集合的常用API:
     - public V put(K key, V value):  把指定的键与指定的值添加到Map集合中。
     - public V remove(Object key): 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
     - public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
     - public Set<K> keySet(): 获取Map集合中所有的键，存储到Set集合中。
     - public boolean containKey(Object key):判断该集合中是否有此键。
 */
public class MapDemo02 {
    public static void main(String[] args) {
        // 创建Map集合对象
        Map<String, Integer> maps = new HashMap<>();
        // 向集合中添加元素
        maps.put("小米",3000);
        maps.put("huawei",1000);
        maps.put("iphone11",6700);
        maps.put("iphone11",8000);
        maps.put("三星",4500);
        // 输出map集合
        System.out.println("map集合:" + maps);    // map集合:{huawei=1000, iphone11=8000, 小米=3000, 三星=4500}
        // 根据键取值
        System.out.println("根据键取值:" + maps.get("小米"));  // 根据键取值:3000
        // 根据键删除整个键值对元素。
        System.out.println(maps.remove("小米"));
        System.out.println("map集合(删除键值对):" + maps); // map集合(删除键值对):{huawei=1000, iphone11=8000, 三星=4500}

        // 获取全部键的集合。因为键是无序不重复的,返回的是Set集合
        Set<String> keys = maps.keySet();
        System.out.println("maps的键值:" + keys);  // maps的键值:[huawei, iphone11, 三星]

        // 获取全部值的集合
        Collection<Integer> values = maps.values();
        System.out.println("maps的值:" + values);     // maps的值:[1000, 8000, 4500]

        // 判断集合是否包含某个值
        System.out.println(maps.containsValue(1000));   // true
        System.out.println(maps.containsValue(800));    // false
        System.out.println(maps.containsValue(4500));   // true
    }
}
