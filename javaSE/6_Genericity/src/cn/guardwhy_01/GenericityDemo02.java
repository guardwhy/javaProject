package cn.guardwhy_01;

import java.util.ArrayList;

/**
 如果不使用泛型，在运行阶段做类型转换的时候，可能出现类型转换异常！
 加入了泛型以后，类型在编译阶段就确定了，之后就永远不会出现类型转换异常。
 */
public class GenericityDemo02 {
    public static void main(String[] args) {
        // 创建字符串对象
        ArrayList<String> lists = new ArrayList<>();
        // 添加集合元素
        lists.add("java");
        lists.add("mybatis");
        lists.add("Spring");

        System.out.println("集合元素:" +lists);

        // 遍历集合
        System.out.print("集合(遍历元素):");
        for(int i=0; i<lists.size(); i++){
            String rs = lists.get(i);
            System.out.print(" " + rs);
        }
    }
}
