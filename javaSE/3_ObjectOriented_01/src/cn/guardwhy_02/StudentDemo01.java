package cn.guardwhy_02;
/**
 * 学生测试类
 */
public class StudentDemo01 {
    public static void main(String[] args) {
        // 创建对象
        Student s = new Student();
        // 对象赋值
        s.setName("curry");
        s.setAge(10);
        // 调用成员函数
        s.display();

        // 使用get方法获取成员变量的值
        System.out.println(s.getName() + "-----" + s.getAge());
        System.out.println(s.getName() + "-----" + s.getAge());
    }
}
