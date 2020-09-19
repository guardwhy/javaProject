package cn.guardwhy_08;

/**
 * 学生类
 */
public class Student {
    // 成员变量
    private String name; // 姓名
    private int age; // 年龄
    private String schoolName; // 校名

    // 无参构造器
    public Student(){

    }

    public Student(String name, int age){
        // 调用本类兄弟构造器
        this(name, age, "北京四中");
    }
    // 代参构造器
    public Student(String name, int age, String schoolName) {
        this.name = name;
        this.age = age;
        this.schoolName = schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
