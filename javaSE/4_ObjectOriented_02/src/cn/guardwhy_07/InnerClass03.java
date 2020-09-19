package cn.guardwhy_07;
/**
在实例内部类中访问当前外部类对象的写法是：外部类名称.this.
 */

// 外部类
class Person{
    // 实例变量
    private int age = 30;
    // 实例内部类
    public class Student{
        private int age = 20;
        // 成员函数
        public void display(){
            int age = 10;
            System.out.println("curry的年龄:" + age);  // curry的年龄:10
            System.out.println("curry的年龄:" + this.age); // curry的年龄:20
            System.out.println("curry的年龄:" + Person.this.age);  // curry的年龄:30
        }
    }
}

// 测试类
public class InnerClass03 {
    public static void main(String[] args) {
        // 创建对象
        Person.Student stu = new Person().new Student();
        // 调用函数
        stu.display();
    }
}
