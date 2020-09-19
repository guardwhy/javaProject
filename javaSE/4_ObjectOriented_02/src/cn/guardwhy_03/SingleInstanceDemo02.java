package cn.guardwhy_03;
/**
 懒汉单例设计模式
 真正需要的时候，才创建一个对象。
 a.定义一个对象变量用于后面存储一个对象，此时是没有创建对象的。
 b.把构造器进行私有化，外面就不能创建新对象。
 c.提供一个方法，等需要对象的时候判断是否有一个唯一对象，如果没有创建一个对象。以后都是直接返回这个对象即可！！
 */

// 懒汉单例设计
class MySingleInstance02{
    // 定义一个对象变量用于保存一个对象
    private static MySingleInstance02 instance02 = null;
    // 把构造器私有起来,对外不开发这样外面就无法创建新的对象。
    private MySingleInstance02(){

    }
    // 返回这个唯一的对象。
    public static MySingleInstance02 getInstance02(){
        // 条件判断,在需要的时候并且这个对象还没有创建的时候才创建一次。
        if(instance02 == null){
            instance02 = new MySingleInstance02();
        }

        // 返回对象
        return instance02;
    }
}

public class SingleInstanceDemo02 {
    public static void main(String[] args) {
        MySingleInstance02 t1 = MySingleInstance02.getInstance02();
        MySingleInstance02 t2 = MySingleInstance02.getInstance02();
        // 输出结果
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t1 == t2);   // true
    }
}
