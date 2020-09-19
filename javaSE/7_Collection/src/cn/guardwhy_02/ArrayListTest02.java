package cn.guardwhy_02;

import java.util.ArrayList;

/**
 * 1:创建集合对象
 * 2:往集合中添加字符串对象
 * 3:遍历集合，首先要能够获取到集合中的每一个元素，这个通过get(int index)方法实现
 * 4:遍历集合，其次要能够获取到集合的长度，这个通过size()方法实现
 * 5:遍历集合的通用格式
 */
public class ArrayListTest02 {
    public static void main(String[] args) {
        // 创建集合对象
        ArrayList<String> array = new ArrayList<String>();
        // 添加对象
        array.add("curry");
        array.add("kobe");
        array.add("james");
        // 获取集合的长度
        System.out.println("集合的长度:" + array.size());

        // 遍历集合
        for(int i=0; i<array.size(); i++){
            String str = array.get(i);
            System.out.println(str);
        }
    }
}
