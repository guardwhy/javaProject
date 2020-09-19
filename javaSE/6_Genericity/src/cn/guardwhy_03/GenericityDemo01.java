package cn.guardwhy_03;

import java.util.ArrayList;

/**
通配符：？
     ? 可以代表一切类型,用在使用泛型的使用。
     E , T , K , V也可以代表一切类型，但是它是用在定义泛型的时候.
泛型的上下限：
     ? extends Car : ?必须是继承了Car或者Car本身。(泛型上限)
     ? super Car : ?必须是Car的父类，或者Car本身。(泛型下限，几乎不用)
总结：
     ？可以用在使用泛型的时候，代表一切类型
     ? extends Car : ?必须是继承了Car或者Car本身。(泛型上限)
*/

// 基类Car
class Car{

}
// 派生类:BMW
class BMW extends Car {

}
// 派生类:Audi
class Audi extends Car {

}

public class GenericityDemo01 {
    public static void main(String[] args) {
        // 创建bmws集合对象
        ArrayList<BMW> bmws = new ArrayList<>();
        bmws.add(new BMW());
        bmws.add(new BMW());
        bmws.add(new BMW());
        // 调用方法
        go(bmws);

        // 创建jeep集合对象
        ArrayList<Car> audis = new ArrayList<>();
        audis.add(new Car());
        audis.add(new Car());
        audis.add(new Car());
        // 调用方法
        go(audis);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        // 调用方法
        go(cars);
    }

    // 声明方法
    public static void go(ArrayList<? extends Car> cars) {
        // .....
    }
}
