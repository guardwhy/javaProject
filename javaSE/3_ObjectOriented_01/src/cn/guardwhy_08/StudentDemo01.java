package cn.guardwhy_08;
/**
 * this：代表当前本类对象
   super:代表父类对象引用。

    this用在本类中可以访问本类对象的成员：
        this.本类成员变量。
        this.本类成员方法。
        this(...):在本类构造器中访问本类其他构造器。

    super用在本类中访问父类的成员:
        super.父类成员变量。
        super.父类成员方法。
        super(...):在本类构造器中访问父类其他构造器。
*/
public class StudentDemo01 {
    public static void main(String[] args) {
        Student s1 = new Student("curry", 10);
        // 输出结果
        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        System.out.println(s1.getSchoolName());

        Student s2 = new Student("kobe", 41, "人大附中");
        // 输出结果
        System.out.println(s2.getName());
        System.out.println(s2.getAge());
        System.out.println(s2.getSchoolName());
    }
}
