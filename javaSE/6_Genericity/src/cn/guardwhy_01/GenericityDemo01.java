package cn.guardwhy_01;

import java.util.ArrayList;

/**
 泛型：其实就是一个标签: <数据类型>
 泛型的作用：可以约束在编译阶段只能操作某种数据类型。
注意：
    泛型只能约束编译阶段。
总结：
 泛型就是一个标签，可以约束在编译阶段只能操作某种数据类型。
 */
public class GenericityDemo01 {
    public static void main(String[] args) {
        // 创建集合对象
        ArrayList<String> lists = new ArrayList<>(); // JDK1.7开始后面的类型可以不写
        // 添加元素
        lists.add("java");
        lists.add("MyBatis");
        lists.add("100");

        // 集合的长度
        System.out.println("集合的长度:" + lists.size());

        // 输出集合元素
        System.out.print("集合元素:");
        System.out.print("[");
        for(int i=0; i < lists.size(); i++){
            String str = lists.get(i);
            // 集合元素
            System.out.print(" " + str);
        }
        System.out.print("]");
    }
}
