package cn.guardwhy_01;

import java.util.HashMap;
import java.util.Map;

/**
 Map集合的自定义类型使用。
 */
public class MapDemo06 {
    public static void main(String[] args) {
        // 创建集合对象
        Map<Student, String> maps = new HashMap<>();
        // 向map集合中添加Student
        maps.put(new Student("curry", 10, '男'), "中山大学体育学院");
        maps.put(new Student("kobe", 40, '男'), "中山大学体育学院");
        maps.put(new Student("james", 33, '男'), "中山大学体育学院");

        // 遍历集合
        maps.forEach((stu, addr) ->{
            System.out.println(stu.getName() + "---" + stu.getAge() + "---" + addr);
        });
    }
}
