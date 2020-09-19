package cn.guardwhy_03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1:定义学生类
 * 2:创建集合对象
 * 3:创建学生对象
 * 4:添加学生对象到集合中
 * 5:遍历集合，采用通用遍历格式实现
 */
public class ArrayListTest01 {
    public static void main(String[] args) {
        // 创建集合对象
        ArrayList<Student> array = new ArrayList<Student>();
        // 调用方法
        addStudent(array);
        // 遍历集合
        for(int i=0; i < array.size(); i++){
            Student st = array.get(i);
            System.out.println("姓名: " + st.getName()  + ", 年龄:" + st.getAge());
        }
    }

    public static void addStudent(ArrayList<Student> array) {
        // 键盘录入学生对象数据
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生姓名: ");
        String name = sc.nextLine();

        System.out.println("请输入学生年龄: ");
        String age = sc.nextLine();

        //创建学生对象,把键盘录入的数据赋值给学生对象的成员变量
        Student st = new Student();
        st.setName(name);
        st.setAge(age);

        // 向集合中添加学生对象
        array.add(st);
    }
}
