package cn.guardwhy_03;
/**
 饿汉单例设计模式
 在用类的时候，对象已经创建好了。
 步骤：
 a.定义一个对象，最好static和final修饰，这样这个对象永远是唯一不可变的对象了。
 b.把构造器进行私有化，外面就不能创建新对象。
 c.提供一个方法把唯一的单例对象返回出去。
 */

// 饿汉单例设计模式
class MySingleInstance01{
    // 定义一个对象
    private static final MySingleInstance01 instance = new MySingleInstance01();

    // 把构造器私有起来,对外不开发这样外面就无法创建新的对象。
    private MySingleInstance01() {

    }
    // 返回唯一的对象
    public static MySingleInstance01 getInstance(){
        return instance;
    }
}

public class SingleInstanceDemo01 {
    public static void main(String[] args) {
        MySingleInstance01 t1 = MySingleInstance01.getInstance();
        MySingleInstance01 t2 = MySingleInstance01.getInstance();
        System.out.println(t1 == t2);   // true
    }
}
