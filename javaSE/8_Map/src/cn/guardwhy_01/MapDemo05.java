package cn.guardwhy_01;
/**
 Map集合的遍历方式：3种。
 （1）键找值的方式遍历：先拿到所有的键，再遍历键获取对应值。（最简单的）
 （2）键值对方式遍历。（老程序员用的多，更面向对象的遍历思想）
 （3）JDK 1.8开始的新技术（普遍使用了）

 3.JDK 1.8开始的新技术（普遍使用了）
 */
import java.util.HashMap;
import java.util.Map;

public class MapDemo05 {
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
        maps.forEach((k, v) ->{
            System.out.println(k + "==>" + v);
        });
    }
}
