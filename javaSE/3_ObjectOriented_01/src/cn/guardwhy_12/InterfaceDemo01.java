package cn.guardwhy_12;
/**
 接口类测试:
 */
public class InterfaceDemo01 {
    public static void main(String[] args) {
        // 创建Stu对象
        Student stu = new Student("curry");
        // 对象.方法
        stu.run();  // curry需要跑步训练...
        stu.study();  // curry在学校认真学习..
    }
}
