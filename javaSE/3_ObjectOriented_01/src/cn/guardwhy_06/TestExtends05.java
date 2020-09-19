package cn.guardwhy_06;
/**
 * 继承后_super调用父类方法:
 * super.父类方法。
*/

// 基类:Animal2
class Animal2{
    // 成员方法
    public void run(){
        System.out.println("动物可以跑步...");
    }

    public void eat(){
        System.out.println("动物可以吃饭...");
    }
}

// 派生类:Dog2
class Dog2 extends Animal2{
    @Override
    public void run() {
        super.run();
        System.out.println("狗正在抓耗子,多管闲事...");
    }

    public void go(){
        // 子类方法
        run();
        // 父类方法
        super.run();
        // 父类方法
        eat();
    }
}

// 测试类
public class TestExtends05 {
    public static void main(String[] args) {
        // 创建对象Dog
        Dog2 dog2 = new Dog2();
        // 对象调用方法
        dog2.go();
    }
}
