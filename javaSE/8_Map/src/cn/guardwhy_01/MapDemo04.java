package cn.guardwhy_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 Map集合的遍历。

 Map集合的遍历方式：3种。
 （1）键找值的方式遍历：先拿到所有的键，再遍历键获取对应值。
 （2）键值对方式遍历.
 （3）JDK 1.8开始的新技术

 2.键值对方式遍历
 */
public class MapDemo04 {
    public static void main(String[] args) {
        // 创建Map集合对象
        Map<String, Integer> maps = new HashMap<>();
        // 向集合中添加元素
        maps.put("小米",30);
        maps.put("huawei",10);
        maps.put("iphone11",67);
        maps.put("iphone11",80);
        maps.put("三星",45);
        // 遍历集合
        Set<Map.Entry<String, Integer>> entries = maps.entrySet();
        for(Map.Entry<String, Integer> entry : entries){
            // 取键
            String key = entry.getKey();
            // 取值
            Integer value = entry.getValue();
            System.out.println(key + "==>" + value);
        }
    }
}
