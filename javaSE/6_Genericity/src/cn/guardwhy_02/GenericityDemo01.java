package cn.guardwhy_02;
/**
 泛型接口：使用了泛型的接口就是泛型接口。

 泛型接口:
     修饰符 interface 接口名<泛型变量>{

     }

 需求：开发一个教务系统。
 可能要对学生和老师信息都进行增删改查操作。
 */
public class GenericityDemo01 {
    public static void main(String[] args) {
        // 创建s1对象
        StudentData s1 = new StudentData();
        // 调用方法
        s1.insert(new Student());
        s1.delete(new Student());

        // 创建t1对象
        TeacherData t1 = new TeacherData();
        t1.insert(new Teacher());
        t1.delete(new Teacher());
    }
}
