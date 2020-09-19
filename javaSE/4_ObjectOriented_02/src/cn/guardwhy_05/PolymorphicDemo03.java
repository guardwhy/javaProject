package cn.guardwhy_05;
/**
多态的类型转换_引用类型的自动类型转换。
    父类类型的范围 > 子类类型的范围
引用类型的自动类型转换:
    子类对象或者子类类型的变量是可以直接自动类型转换给父类类型的变量（自动类型转换，向上转型）
 前提：必须有继承关系才可以类型转换！！
*/

// 基类:Person
class Person{

}
// 派生类:Student
class Student extends Person{

}
// 测试类
public class PolymorphicDemo03 {
    public static void main(String[] args) {
        Person ps = new Student();  // 子类对象赋值给父类类型的变量,自动类型转换。

        Student stu = new Student();
        Person ps1 = stu;   // 子类类型的变量赋值给父类类型的变量,自动类型转换。
    }
}
