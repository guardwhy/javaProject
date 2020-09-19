package cn.guardwhy_01;

import java.util.ArrayList;

/**
 泛型类的概念：使用了泛型的类就是泛型类。

 泛型类的定义格式：
     修饰符 class 类名称<泛型变量>{

     }
    泛型变量：用于接收真实的数据类型。
    泛型变量按照规范一般取名为：E , T  , K , V

总结：
 泛型类的变量是：E , T , K , V
 泛型的核心思想：是把泛型变量全部替换成传入的真实数据类型.

 需求：模拟ArrayList集合类定义一个DleiArrayList
 */
class DleiArrayList<E>{
    // 创建lists集合
    private ArrayList lists1 = new ArrayList();
    // 添加方法
    public void add(E e){
        lists1.add(e);
    }
    // 删除操作
    public void remove(E e){
        lists1.remove(e);
    }

    @Override
    public String toString() {
        return lists1.toString();
    }
}
public class GenericityDemo03 {
    public static void main(String[] args) {
        // 创建lists2集合
        DleiArrayList<String> lists2 = new DleiArrayList<>();
        // 添加集合元素
        lists2.add("curry");
        lists2.add("is");
        lists2.add("总冠军");
        // 输出集合元素
        System.out.println("lists2集合:" + lists2);

        // 创建lists3集合
        DleiArrayList<Integer> lists3 = new DleiArrayList<>();
        // 添加集合元素
        lists3.add(10);
        lists3.add(20);
        lists3.add(30);
        // 输出集合元素
        System.out.println("lists3集合:" + lists3);
    }
}
