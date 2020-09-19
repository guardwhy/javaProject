package cn.guardwhy_02;

import java.util.ArrayList;
/**
* 1:定义学生类
* 2:创建集合对象
* 3:创建学生对象
* 4:添加学生对象到集合中
* 5:遍历集合，采用通用遍历格式实现
*/
public class ArrayListTest03 {
    public static void main(String[] args) {
        // 创建集合对象
        ArrayList<Student> array = new ArrayList<Student>();
        // 创建学生对象
        Student s1 = new Student("curry", 10);
        Student s2 = new Student("kobe", 41);
        Student s3 = new Student("james", 35);
        // 添加学生对象到集合中
        array.add(s1);
        array.add(s2);
        array.add(s3);
        // 遍历集合
        for(int i=0; i < array.size(); i++){
            Student st = array.get(i);
            System.out.println(st.getName() + "," + st.getAge());
        }
    }
}
