package cn.guardwhy_14;
/**
 *  接口与接口的多继承。
 *
 *     类与类是单继承关系。 一个类只能继承一个父类。
 *     类与接口是多实现关系。一个类可以同时实现多个接口。
 *     接口与接口是多继承关系。一个接口可以继承多个接口。
 */

// 定义接口Law
interface Law{
    void rule(); // 守法
}

// 定义接口Go
interface Go{
    void abroad(); // 出国
}

// 接口与接口的多继承
interface Person extends Law, Go{
    void run();
    void study();
}

// 接口类实现
class Student implements Person{

    @Override
    public void rule() {

    }

    @Override
    public void abroad() {

    }

    @Override
    public void run() {

    }

    @Override
    public void study() {

    }
}

public class InterfaceDemo01 {
    public static void main(String[] args) {

    }
}
