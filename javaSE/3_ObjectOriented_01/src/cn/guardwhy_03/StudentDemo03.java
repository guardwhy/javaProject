package cn.guardwhy_03;
/**
 创建对象的两种方式:
 1:无参构造方法创建对象后使用setXxx()赋值
 2:使用带参构造方法直接创建带有属性值的对象
 */
public class StudentDemo03 {
    public static void main(String[] args) {
        // 无参构造方法创建对象
        Student s1 = new Student();
        s1.setName("curry");
        s1.setAge(10);
        // 调用成员函数
        s1.display();

        // 使用代参构造方法直接创建对象
        Student s2 = new Student("kobe", 41);
        s2.display();
    }
}
